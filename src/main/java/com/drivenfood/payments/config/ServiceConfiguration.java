package com.drivenfood.payments.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
