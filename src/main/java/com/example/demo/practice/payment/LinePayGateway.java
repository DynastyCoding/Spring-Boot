package com.example.demo.practice.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LinePayGateway implements PaymentGateway {

    @Override
    public boolean charge(Long orderId, BigDecimal amount){
        System.out.println("Use LinePay deduction, book: " + orderId +
                            ", amount: " + amount);
        return true;
    }


}