package com.ml.coreweb.service;

import com.ml.coreweb.domain.OrderDetails;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderDetailsService {
	OrderDetails save(OrderDetails orderDetails);
	
	List<OrderDetails> findAll();
}
