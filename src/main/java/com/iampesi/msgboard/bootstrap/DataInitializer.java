package com.iampesi.msgboard.bootstrap;

import com.iampesi.msgboard.domain.Comment;
import com.iampesi.msgboard.domain.Post;
import com.iampesi.msgboard.domain.User;
import com.iampesi.msgboard.repository.CommentRepository;
import com.iampesi.msgboard.repository.PostRepository;
import com.iampesi.msgboard.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    
    public DataInitializer(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // clear the database after every restart
        postRepository.deleteAll();
        userRepository.deleteAll();
        commentRepository.deleteAll();
        
        // ============================
        // 1st user and posts
        
        User user1 = new User();
        user1.setDateJoin(LocalDate.now());
        user1.setLocation("Seattle");
        user1.setUsername("user1");
        user1.setEmail("user1@email.com");
        user1.setPassword("mypassword");
        
        List<Post> postList = new ArrayList<>();
        Post post = new Post("My first post", "Hi, this is my first post", LocalDate.now());
        Post post2 = new Post("My second post", "Wow, my second post", LocalDate.now());
    
        postList.add(post);
        postList.add(post2);

        post.setUser(user1);
        post2.setUser(user1);
        user1.setPosts(postList);

        
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment("Wow, this is awesome stuff", LocalDate.now(), user1, post);
        commentList.add(comment);
        user1.setComments(commentList);
        post.setComments(commentList);
        
        userRepository.save(user1);
    
        // =============================
        // 2nd user and posts
        User user2 = new User();
        user2.setDateJoin(LocalDate.now());
        user2.setLocation("Portland");
        user2.setUsername("user2");
        user2.setEmail("user2@email.com");
        user2.setPassword("$2a$12$eWagLOJmNlN3DmiEccxS5eohQ3dlxJUzU/ZA2Hl1JwBBNRAqhgkiG");

        List<Post> postList2 = new ArrayList<>();
        user2.setPosts(postList2);

        Post user2Post = new Post("Whoohoo", "Hi, this is my first post", LocalDate.now());
        Post user2Post2 = new Post("Lonely here", "Wow, my second post", LocalDate.now());

        postList2.add(user2Post);
        postList2.add(user2Post2);
        user2Post.setUser(user2);
        user2Post2.setUser(user2);


        List<Comment> commentList2 = new ArrayList<>();
        Comment comment2 = new Comment("Meh, this isn't anything new", LocalDate.now(), user2, post2);
        commentList2.add(comment2);
        post2.setComments(commentList2);
        user2.setComments(commentList2);

        userRepository.save(user2);
        
//        User wow = new User();
//        wow = userRepository.getReferenceById(1L);



//        System.out.println(user1.toString());
        
//        postRepository.save(post1);
//        System.out.println("Post Id: " + post1.getId());
//        List<Post> user1Posts = new ArrayList<>();
//        Post user1Post = new Post("user1 first post", "Hi, this is user1", "April 1, 2023");
//        user1Posts.add(user1Post);
//        user1.setPosts(user1Posts);
    }
}
