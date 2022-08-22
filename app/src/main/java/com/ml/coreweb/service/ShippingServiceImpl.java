package com.ml.coreweb.service;

import com.ml.coreweb.domain.ShippingAddress;
import com.ml.coreweb.repository.ShippingRepository;
import com.ml.coreweb.service.ShippingService;
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
