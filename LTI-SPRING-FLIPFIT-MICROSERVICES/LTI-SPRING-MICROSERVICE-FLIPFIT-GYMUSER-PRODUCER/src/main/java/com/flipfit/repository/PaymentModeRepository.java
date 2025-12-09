package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.flipfit.entity.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long> {

}
