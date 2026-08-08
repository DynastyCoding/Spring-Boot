package com.example.demo.Class.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/register")
    public String register(@RequestBody RegisterRequest req){
        User user = new User();

        user.setUsername(req.username());
        user.setPassword(passwordEncoder.encode(req.password()));  // 加密後再存
        user.setRole("USER");                                      // 不帶 ROLE_ 前綴
        userRepository.save(user);
        return "註冊成功：" + user.getUsername();
    }

    @GetMapping("/api/me")
    public String me(){
        return SecurityContextHolder.getContext()
                .getAuthentication().getName();
    }
}
