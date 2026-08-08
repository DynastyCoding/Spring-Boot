package com.example.demo.Class.practice.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentService {

    private PaymentGateway paymentGateway;

    @Autowired
    public PaymentService(@Qualifier("linePayGateway")PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void pay(Long orderId, BigDecimal amount){

        boolean success = paymentGateway.charge(orderId, amount);

        if(success){
            System.out.println("Payment successful.");
        }else{
            System.out.println("Payment failed.");
        }
    }
}
