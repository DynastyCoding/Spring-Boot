package com.example.demo.ControllerPractice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @RequestMapping("/members/search")
    public String search(@RequestParam("keyword") String keyword,
                         @RequestParam("limit") Integer limit){
        return "search keyword: " + keyword + ", most return " + limit + " records";
    }

    @RequestMapping("/members/register")
    public String register(@RequestBody Member member){
        return "resign successful, email: " + member.getEmail();
    }

}


