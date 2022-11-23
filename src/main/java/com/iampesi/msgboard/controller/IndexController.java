package com.iampesi.msgboard.controller;

import com.iampesi.msgboard.repository.PostRepository;
import com.iampesi.msgboard.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final PostRepository postRepository;

    public IndexController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    private String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
//        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}
