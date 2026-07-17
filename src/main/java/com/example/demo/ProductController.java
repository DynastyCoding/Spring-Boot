package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(){
        return "search store list";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String creatProduct(){
        return "add a store";
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public String putProduct(){
        return "renew store";
    }
}
