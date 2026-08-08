package com.example.demo.Class.practice.payment;

import java.math.BigDecimal;

public interface PaymentGateway {

    boolean charge(Long orderId, BigDecimal amount);
}
