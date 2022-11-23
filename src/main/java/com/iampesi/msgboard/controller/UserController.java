package com.iampesi.msgboard.controller;

import com.iampesi.msgboard.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/{id}")
    public String user(@PathVariable String id, Model model) {
        Long userId = Long.valueOf(id);
        
        model.addAttribute("user", userRepository.getOne(userId));
        
        return "user";
    }
}
