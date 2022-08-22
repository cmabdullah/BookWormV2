package com.ml.app.service;

import com.ml.app.domain.*;
import com.ml.app.repository.OrderRepository;
import com.ml.app.request.OrderDetailsRequest;
import com.ml.app.request.OrderRequestDto;
import com.ml.app.request.ProductRequestDto;
import com.ml.app.response.OrderResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
		long addressId = orderRequestDto.getShippingAddress().getAddressId();//check address id is null or not
		
		ShippingAddress shippingAddress = shippingService.findById(addressId).orElseGet(() -> {
			ShippingAddress newShippingAddress = getNewShippingAddressFromRequestDto(orderRequestDto);
			return shippingService.save(newShippingAddress);
		});
		

		
		long paymentId = orderRequestDto.getPayment().getId();
		Payment payment = paymentService.findById(paymentId).orElseGet(() -> {
			Payment newPayment = getNewPaymentFromRequestDto(orderRequestDto);
			Payment savedPayment = paymentService.save(newPayment);
			log.info("payment saved" + savedPayment.toString());
			return savedPayment;
		});
		
		OrderDetailsRequest orderDetailsRequest = orderRequestDto.getOrderDetails();
		List<Long> productIdList = orderDetailsRequest.getProducts().stream()
										   .map(ProductRequestDto::getProductId).collect(Collectors.toList());
		
		List<Product> productList = productService.findAllProductByProductId(productIdList);
		
		//initialize order
		Order newOrder = Order.builder().orderTotal(orderRequestDto.getOrderTotal()).shippingMethod(orderRequestDto.getShippingMethod())
				.shippingAddress(shippingAddress).payment(payment).orderStatus("success").build();
		Order savedOrder = orderRepository.save(newOrder);
		log.info("order saved "+savedOrder.toString());
		
		OrderDetails orderDetails = OrderDetails.builder().qty(orderDetailsRequest.getQty()).products(productList)
											.order(savedOrder).build();
		
		OrderDetails savedOrderDetails = orderDetailsService.save(orderDetails);
		log.info("saved order details"+savedOrderDetails.toString());
		
		return OrderResponseDto.builder().orderStatus(savedOrder.getOrderStatus()).build();
	}
	
	@Override
	public List<OrderDetails> getAllOrdersBasedOnProductName(String productName) {
		//get all order, i will optimise later
		List<OrderDetails> orderDetailsList = orderDetailsService.findAll();
		List<OrderDetails> filteredOrderDetailsList = orderDetailsList.stream().filter(orderDetails -> {
			List<Product> productList = orderDetails.getProducts()
												.stream().filter(product -> product.getProductName().contains(productName))
												.collect(Collectors.toList());
			return CollectionUtils.isNotEmpty(productList);
		}).collect(Collectors.toList());
		Comparator<OrderDetails> comparator = (s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt());
		List<OrderDetails> sortedOrderDetailsList = filteredOrderDetailsList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedOrderDetailsList;
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
}
