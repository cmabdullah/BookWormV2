package com.ml.coreweb.service;

import com.ml.coreweb.domain.ShippingAddress;
import com.ml.coreweb.request.OrderRequestDto;
import com.ml.coreweb.response.OrderResponseDto;
import org.springframework.stereotype.Service;
import com.ml.coreweb.domain.Order;
/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Override
	public OrderResponseDto save(OrderRequestDto orderRequestDto) {
		//ShippingAddress shippingAddress =
		Order.builder().orderTotal(orderRequestDto.getOrderTotal())
				.shippingMethod(orderRequestDto.getShippingMethod())
//				.shippingAddress()
//				.cartItemList()
//				.payment()
				.build();
		
		return null;
	}
}
