package com.ml.coreweb.service;

import com.ml.coreweb.domain.Payment;

import java.util.Optional;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface PaymentService {
	Optional<Payment> findById(long paymentId);
	
	Payment save(Payment payment);
}
