package com.ml.coreweb.service;

import com.ml.coreweb.domain.Payment;
import com.ml.coreweb.repository.PaymentRepository;
import com.ml.coreweb.service.PaymentService;
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
public class PaymentServiceImpl implements PaymentService {
	private final PaymentRepository paymentRepository;
	
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository){
		this.paymentRepository = paymentRepository;
	}
	
	
	@Override
	public Optional<Payment> findById(long paymentId) {
		return paymentRepository.findById(paymentId);
	}
	
	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}
}
