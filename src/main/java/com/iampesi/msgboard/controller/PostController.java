package com.iampesi.msgboard.controller;

import com.iampesi.msgboard.domain.Comment;
import com.iampesi.msgboard.domain.Post;
import com.iampesi.msgboard.repository.CommentRepository;
import com.iampesi.msgboard.repository.PostRepository;
import com.iampesi.msgboard.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("posts")
public class PostController {
    
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    
    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    
//    @GetMapping("/")
//    private String index(Model model) {
//        model.addAttribute("posts", postRepository.findAll());
////        model.addAttribute("users", userRepository.findAll());
//
//        return "index";
//    }
    
    @GetMapping("{id}")
    public String post(@PathVariable Long id, Model model) {
        
        model.addAttribute("post", postRepository.getOne(id));
//        model.addAttribute("comments", postRepository.getOne(postId).get);
        
        return "post";
    }
    
    @PostMapping("{id}/createpost")
    public String postSubmit(Model model) {
//        model.addAttribute("post", )
        return "post";
    }

//    @PostMapping("{id}/submitComment")
//    public String commentSubmit(@PathVariable Long id, @RequestParam("comment") String comment) {
//        Comment newComment = new Comment(comment, LocalDate.now(), postRepository.getById(1L).getUser(), postRepository.getOne(id));
//        postRepository.findById(id).get().getComments().add(newComment);
//
//        return "post";
//    }
}
