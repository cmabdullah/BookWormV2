package com.ml.app.service;

import com.ml.app.constants.ApiMessage;
import com.ml.app.domain.*;
import com.ml.app.repository.OrderRepository;
import com.ml.app.request.OrderRequestDto;
import com.ml.app.request.ProductRequestDto;
import com.ml.app.request.ShippingAddressDto;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.response.ProductResponseDto;
import com.ml.coreweb.exception.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final PaymentService paymentService;
	private final ShippingService shippingService;
	private final ProductService productService;
	private final OrderDetailsService orderDetailsService;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository,
							PaymentService paymentService,
							ShippingService shippingService,
							ProductService productService,
							OrderDetailsService orderDetailsService) {
		this.orderRepository = orderRepository;
		this.paymentService = paymentService;
		this.shippingService = shippingService;
		this.productService = productService;
		this.orderDetailsService = orderDetailsService;
	}
	
	@Override
	public OrderResponseDto save(OrderRequestDto orderRequestDto) {
		
		List<ProductRequestDto> productRequestDtoList = orderRequestDto.getOrderDetails();
		
		Map<Long, Integer> productIdMapWithQuantity = new HashMap<>();
		productRequestDtoList.stream().filter(Objects::nonNull)
				.forEach(productRequest -> {
					long productId = productRequest.getProductId();
					if (!productIdMapWithQuantity.containsKey(productId)) {
						int qty = productRequest.getQty();
						productIdMapWithQuantity.put(productId, qty);
					} else {
						int existingQty = productIdMapWithQuantity.get(productId);
						int currentQty = productRequest.getQty();
						
						if (existingQty + currentQty <= 4) {
							productIdMapWithQuantity.put(productId, existingQty + currentQty);
						} else {
							throw new ApiError(ApiMessage.MAX_LIMIT_ERROR, HttpStatus.BAD_REQUEST);
						}
					}
				});
		
		long addressId = orderRequestDto.getShippingAddress().getAddressId();//check address id is null or not
		
		ShippingAddress shippingAddress = shippingService.findById(addressId).orElseGet(() -> {
			ShippingAddress newShippingAddress = getNewShippingAddressFromRequestDto(orderRequestDto);
			return shippingService.save(newShippingAddress);
		});
		List<Long> productIdList = new ArrayList<>(productIdMapWithQuantity.keySet());
		List<Product> productList = productService.findAllProductByProductId(productIdList);
		
		double totalPrice = productList.stream().filter(Objects::nonNull).map(Product::getProductPrice)
									.mapToDouble(Double::doubleValue).sum();
		//initialize order
		Order newOrder = Order.builder().totalPrice(totalPrice)
								 .shippingMethod(orderRequestDto.getShippingMethod())
								 .shippingAddress(shippingAddress).orderStatus("success").build();
		Order savedOrder = orderRepository.save(newOrder);
		log.info("order saved " + savedOrder.toString());
		
		Payment newPayment = getNewPaymentFromRequestDto(orderRequestDto);
		newPayment.setOrder(savedOrder);
		Payment savedPayment = paymentService.save(newPayment);
		log.info("payment saved" + savedPayment.toString());
		
		List<OrderDetails> orderDetailsList = productList.stream().filter(Objects::nonNull)
													  .filter(product -> productIdMapWithQuantity.containsKey(product.getId()))
													  .map(product -> {
														  return OrderDetails.builder().subQty(productIdMapWithQuantity.get(product.getId()))
																		 .price(product.getProductPrice())
																		 .product(product)
																		 .order(savedOrder).build();
													  }).collect(Collectors.toList());
		
		List<OrderDetails> savedOrderDetails = orderDetailsService.saveAll(orderDetailsList);
		log.info("saved order details" + savedOrderDetails.toString());
		
		List<ProductResponseDto> productResponseDtoList =
				savedOrderDetails.stream().map(orderDetails -> productToProductResponseDto(
						orderDetails.getProduct())).collect(Collectors.toList());
		
		return orderToOrderResponseDto(savedOrder, productResponseDtoList);
	}
	
	@Override
	public List<OrderResponseDto> getAllOrdersBasedOnProductName(String productName, String sku, String category) {
		List<OrderResponseDto> orderList = getOrderList();
		List<OrderResponseDto> filteredOrderList = orderList.stream().filter(orderResponse -> {
			List<ProductResponseDto> products = orderResponse.getProducts();
			
			List<ProductResponseDto> filteredProductsList =
					products.stream().filter(product -> product.getProductName().contains(productName) ||
																product.getProductSKU().contains(sku) ||
																product.getProductCategory().contains(category))
							.collect(Collectors.toList());
			
			if (filteredProductsList.size() != 0) {
				orderResponse.setProducts(filteredProductsList);
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		
		return filteredOrderList;
	}
	
	//this method will return user's orders
	@Override
	public List<OrderResponseDto> getOrderList() {
		long userId = 100l;
		//i will optimise later
		//user id will be find from user object
		List<Order> orderList = orderRepository.findAll();
		Comparator<Order> comparator = (s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt());
		List<OrderResponseDto> orderResponseDtos =
				orderList.stream()
						.filter(Objects::nonNull)
						.sorted(comparator)
						//.filter(userId)
						.map(order -> {
							List<ProductResponseDto> productResponseDtoList = prepareProductResponseDto(order.getOrderDetailsList());
							return orderToOrderResponseDto(order, productResponseDtoList);
						}).collect(Collectors.toList());
		
		return orderResponseDtos;
	}
	
	//this method will return all orders
	@Override
	public List<OrderResponseDto> getAllOrders() {
		//i will optimise later
		List<Order> orderList = orderRepository.findAll();
		
		List<OrderResponseDto> orderResponseDtos =
				orderList.stream()
						.filter(Objects::nonNull)
						.map(order -> {
							List<ProductResponseDto> productResponseDtoList = prepareProductResponseDto(order.getOrderDetailsList());
							return orderToOrderResponseDto(order, productResponseDtoList);
						}).collect(Collectors.toList());
		
		return orderResponseDtos;
	}
	
	private Payment getNewPaymentFromRequestDto(OrderRequestDto orderRequestDto) {
		return Payment.builder()
					   .type(orderRequestDto.getPayment().getType())
					   .cardName(orderRequestDto.getPayment().getCardName())
					   .cardNumber(orderRequestDto.getPayment().getCardNumber())
					   .cvc(orderRequestDto.getPayment().getCvc())
					   .build();
	}
	
	private ShippingAddress getNewShippingAddressFromRequestDto(OrderRequestDto orderRequestDto) {
		return ShippingAddress.builder()
					   .city(orderRequestDto.getShippingAddress().getCity())
					   .houseNo(orderRequestDto.getShippingAddress().getHouseNo())
					   .roadNo(orderRequestDto.getShippingAddress().getRoadNo())
					   .state(orderRequestDto.getShippingAddress().getState())
					   .country(orderRequestDto.getShippingAddress().getCountry())
					   .zipcode(orderRequestDto.getShippingAddress().getZipcode()).build();
	}
	
	private ShippingAddressDto getShippingAddressDtoFromShippingAddress(ShippingAddress shippingAddress) {
		return ShippingAddressDto.builder()
					   .city(shippingAddress.getCity())
					   .houseNo(shippingAddress.getHouseNo())
					   .roadNo(shippingAddress.getRoadNo())
					   .state(shippingAddress.getState())
					   .country(shippingAddress.getCountry())
					   .zipcode(shippingAddress.getZipcode()).build();
	}
	
	private ProductResponseDto productToProductResponseDto(Product product) {
		return ProductResponseDto.builder()
					   .productId(product.getId())
					   .productName(product.getProductName())
					   .productDescription(product.getProductDescription())
					   .productPrice(product.getProductPrice())
					   .productSKU(product.getProductSKU())
					   .productWeight(product.getProductWeight())
					   .productCategory(product.getCategories().getCategoryName())
					   .build();
	}
	
	private OrderResponseDto orderToOrderResponseDto(Order order, List<ProductResponseDto> productResponseDtoList) {
		return OrderResponseDto.builder()
					   .orderId(order.getId())
					   .orderStatus(order.getOrderStatus())
					   .shippingMethod(order.getShippingMethod())
					   .totalPrice(order.getTotalPrice())
					   .products(productResponseDtoList)
					   .shippingAddress(getShippingAddressDtoFromShippingAddress(order.getShippingAddress()))
					   .build();
	}
	
	private List<ProductResponseDto> prepareProductResponseDto(List<OrderDetails> orderDetailsList) {
		return orderDetailsList.stream().map(orderDetails -> productToProductResponseDto(
				orderDetails.getProduct())).collect(Collectors.toList());
	}
}
