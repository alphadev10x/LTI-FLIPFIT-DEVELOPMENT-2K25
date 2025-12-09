/**
 * 
 */
package com.flipfit.services;

import org.springframework.stereotype.Service;

import com.flipfit.entity.Payment;
import com.flipfit.repository.PaymentRepository;

/**
 * 
 */
@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;

	/**
	 * @param paymentRepository
	 */
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public Payment processPayment(Long customerId, Long centerId, double amount) {
		Payment payment = new Payment(customerId, centerId, amount, "SUCCESS");
		return paymentRepository.save(payment);
	}
}
