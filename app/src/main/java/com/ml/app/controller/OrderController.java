package com.ml.app.controller;

import com.ml.app.domain.OrderDetails;
import com.ml.app.request.OrderRequestDto;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.service.OrderService;
import com.ml.coreweb.response.ApiResponse;
import com.ml.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@RestController
@Slf4j
@RequestMapping("/auth/api/")
public class OrderController {
	
	private final OrderService orderService;
	private final EmailService emailService;
	
	
	@Autowired
	public OrderController(OrderService orderService,
						   EmailService emailService){
		this.orderService = orderService;
		this.emailService = emailService;
	}
	
	@PostMapping("/order/submit")
	public ApiResponse<?> addProducts(@Valid @RequestBody OrderRequestDto orderRequestDto) {
		log.info(orderRequestDto.toString());
		OrderResponseDto orderResponseDto = orderService.save(orderRequestDto);
		Map<String, Object> map = Map.of("to", "cmabdullah21@gmail.com",
				"subject","Order Info", "order status",orderResponseDto.getOrderStatus());
		emailService.sendEmailWithAttachment(map);
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
