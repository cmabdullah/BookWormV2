package com.ml.app.service;

import com.ml.app.domain.ShippingAddress;
import com.ml.app.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Service
public class ShippingServiceImpl implements ShippingService {
	
	private final ShippingRepository shippingRepository;
	
	@Autowired
	public ShippingServiceImpl(ShippingRepository shippingRepository){
		this.shippingRepository = shippingRepository;
	}
	
	@Override
	public Optional<ShippingAddress> findById(long addressId) {
		return shippingRepository.findById(addressId);
	}
	
	@Override
	public ShippingAddress save(ShippingAddress newShippingAddress) {
		return shippingRepository.save(newShippingAddress);
	}
}
