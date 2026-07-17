package com.example.demo.ControllerPractice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/orders/{orderId}")
    public String getOrder(@PathVariable("orderId") Integer orderId,
                           @RequestHeader("token") String token){
        return "book order's number: " + orderId + ", verify token: " + token;
    }

}
