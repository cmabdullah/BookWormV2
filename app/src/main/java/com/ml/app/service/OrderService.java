package com.ml.app.service;

import com.ml.app.domain.OrderDetails;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.request.OrderRequestDto;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderService {
	//@Transactional(rollbackFor = Exception.class)
	OrderResponseDto save(OrderRequestDto orderRequestDto);
	
	List<OrderDetails> getAllOrdersBasedOnProductName(String productCategory);
}
