package com.ml.app.controller;

import com.ml.app.request.OrderRequestDto;
import com.ml.app.request.SearchRequestDto;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.service.OrderService;
import com.ml.auth.common.UserPrincipal;
import com.ml.coreweb.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@RestController
@Slf4j
public class OrderController {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService){
		this.orderService = orderService;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] this url accept order submit request -> Done")
	@PostMapping("/order/submit")
	public ApiResponse<?> addProducts(Authentication authentication, @Valid @RequestBody OrderRequestDto orderRequestDto) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userEmail = ((UserPrincipal) userDetails).getEmail();
		log.info(orderRequestDto.toString());
		OrderResponseDto orderResponseDto = orderService.save(userEmail, orderRequestDto);
		
		return new ApiResponse<>(orderResponseDto);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] return all orders related to this user -> Done")
	@GetMapping("/order/list")
	public ApiResponse<?> getAllOrderByUser(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userEmail = ((UserPrincipal) userDetails).getEmail();
		List<OrderResponseDto> orderResponseDto = orderService.getOrderList(userEmail);
		return new ApiResponse<>(orderResponseDto);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] search order based on product name, sku, and product category -> Done")
	@PostMapping("/order/getOrderBasedOnProductName")
	public ApiResponse<?> getAllOrderBasedOnProductName(Authentication authentication, @RequestBody SearchRequestDto searchRequest) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userEmail = ((UserPrincipal) userDetails).getEmail();
		List<OrderResponseDto> orderResponseDto = orderService.getAllOrdersBasedOnProductName(userEmail,
				searchRequest.getProductName(), searchRequest.getSku(), searchRequest.getCategory());
		return new ApiResponse<>(orderResponseDto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "[TEST] admin can search all order list -> Done")
	@GetMapping("/order/getAllOrders")
	public ApiResponse<?> getAllOrders() {
		List<OrderResponseDto> orderResponseDto = orderService.getAllOrders();
		return new ApiResponse<>(orderResponseDto);
	}
	
}
