package com.drivenfood.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drivenfood.payments.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
