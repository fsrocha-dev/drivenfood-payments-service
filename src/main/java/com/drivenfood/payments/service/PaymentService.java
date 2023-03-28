package com.drivenfood.payments.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drivenfood.payments.dto.PaymentDto;
import com.drivenfood.payments.model.Payment;
import com.drivenfood.payments.model.Status;
import com.drivenfood.payments.repository.PaymentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<PaymentDto> getAll(Pageable paginate) {
		return repository
				.findAll(paginate)
				.map(p -> modelMapper.map(p, PaymentDto.class));
	}

	public PaymentDto getById(Long id) {
		Payment payment = repository.findById(id)
				.orElseThrow(EntityNotFoundException::new);

		return modelMapper.map(payment, PaymentDto.class);
	}

	public PaymentDto criarPagamento(PaymentDto dto) {
		Payment payment = modelMapper.map(dto, Payment.class);
		payment.setStatus(Status.CREATED);
		repository.save(payment);

		return modelMapper.map(payment, PaymentDto.class);
	}

	public PaymentDto atualizarPagamento(Long id, PaymentDto dto) {
		Payment payment = modelMapper.map(dto, Payment.class);
		payment.setId(id);
		payment = repository.save(payment);
		return modelMapper.map(payment, PaymentDto.class);
	}

	public void excludePayment(Long id) {
		repository.deleteById(id);
	}

}
