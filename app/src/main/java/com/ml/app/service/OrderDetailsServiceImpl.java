package com.ml.app.service;

import com.ml.app.domain.OrderDetails;
import com.ml.app.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	private final OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository){
		this.orderDetailsRepository = orderDetailsRepository;
	}
	
	@Override
	public OrderDetails save(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}
	
	@Override
	public List<OrderDetails> findAll() {
		return orderDetailsRepository.findAll();
	}

//	public OrderDetails findAllOrderByProductName(String productName) {
//
//		List<OrderDetails> list = orderDetailsRepository.findAllByProductsWhereProductName(productName);
//		return null;
//	}
}
