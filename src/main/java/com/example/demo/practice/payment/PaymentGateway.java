package com.example.demo.practice.payment;

import java.math.BigDecimal;

public interface PaymentGateway {

    boolean charge(Long orderId, BigDecimal amount);
}
