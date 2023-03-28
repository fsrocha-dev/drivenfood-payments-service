package com.drivenfood.payments.dto;

import java.math.BigDecimal;

import com.drivenfood.payments.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
	private Long id;
	private BigDecimal value;
	private String name;
	private String number;
	private String expiration;
	private String code;
	private Status status;
	private Long orderId;
	private Long paymentMethodId;
}
