package com.ml.coreweb.service;

import com.ml.coreweb.request.OrderRequestDto;
import com.ml.coreweb.response.OrderResponseDto;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderService {
	OrderResponseDto save(OrderRequestDto orderRequestDto);
}
