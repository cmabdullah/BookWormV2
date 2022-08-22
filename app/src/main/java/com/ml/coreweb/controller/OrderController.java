package com.ml.coreweb.controller;

import com.ml.coreweb.domain.OrderDetails;
import com.ml.coreweb.request.OrderRequestDto;
import com.ml.coreweb.response.ApiResponse;
import com.ml.coreweb.response.OrderResponseDto;
import com.ml.coreweb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/order/submit")
	public ApiResponse<?> addProducts(@Valid @RequestBody OrderRequestDto orderRequestDto) {
		log.info(orderRequestDto.toString());
		OrderResponseDto orderResponseDto = orderService.save(orderRequestDto);
		
		return new ApiResponse<>(orderResponseDto);
	}
	
	//get order list of user
	
	@GetMapping("/order/getOrderBasedOnProductName/{productCategory}")
	public ApiResponse<?> getAllOrderBasedOnProductName(@Valid @PathVariable(value = "productCategory")
															String productCategory) {
		log.info("productCategory "+productCategory);
		List<OrderDetails> orderResponseDto = orderService.getAllOrdersBasedOnProductName(productCategory);
		return new ApiResponse<>(orderResponseDto);
	}
	
}
