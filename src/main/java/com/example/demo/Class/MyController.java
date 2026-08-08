package com.example.demo.Class;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final Printer printer;

    public MyController(@Qualifier("hpPrinter") Printer printer) {
        this.printer = printer;
    }

    @RequestMapping("/test")
    public String test() {
        printer.print("Hi!");
        return "Hello World";
    }

    @RequestMapping("/fuck")
    public String fuck(){
        return "shit man";
    }

    @RequestMapping("/suck")
    public String suck(){
        return "suck my d**k";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(){
        return "使用者清單";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String creatUser(){
        return "新增使用者";
    }


}