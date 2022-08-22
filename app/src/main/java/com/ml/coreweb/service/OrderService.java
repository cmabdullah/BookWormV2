package com.ml.coreweb.service;

import com.ml.coreweb.domain.OrderDetails;
import com.ml.coreweb.request.OrderRequestDto;
import com.ml.coreweb.response.OrderResponseDto;

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
