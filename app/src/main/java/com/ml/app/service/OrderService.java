package com.ml.app.service;

import com.ml.app.domain.OrderDetails;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.request.OrderRequestDto;

import javax.transaction.Transactional;
import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderService {
	@Transactional
	OrderResponseDto save(String userEmail, OrderRequestDto orderRequestDto);
	
	List<OrderResponseDto> getAllOrdersBasedOnProductName(String userEmail, String productName, String sku, String category);
	
	List<OrderResponseDto> getOrderList(String userEmail);
	List<OrderResponseDto>  getAllOrders();
}
