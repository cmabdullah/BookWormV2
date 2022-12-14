package com.ml.app.service;

import com.ml.app.domain.ShippingAddress;

import java.util.Optional;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface ShippingService {
	Optional<ShippingAddress> findById(long addressId);
	
	ShippingAddress save(ShippingAddress newShippingAddress);
}
