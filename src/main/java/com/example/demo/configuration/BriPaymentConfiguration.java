package com.example.demo.configuration;

import com.example.module.bri.BriPaymentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(value = "payment.bri.active", matchIfMissing = true)
@Import(BriPaymentService.class)
public class BriPaymentConfiguration {
}
