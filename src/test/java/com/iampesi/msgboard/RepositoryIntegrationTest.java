package com.iampesi.msgboard;

import com.iampesi.msgboard.domain.Comment;
import com.iampesi.msgboard.domain.Post;
import com.iampesi.msgboard.domain.User;
import com.iampesi.msgboard.repository.CommentRepository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryIntegrationTest {
    @Autowired
    CommentRepository commentRepository;
    
    @Test
    void testDeleteComment() {
        Date today = new Date();
        today.setHours(0);
        
        User testUser = new User("test-user", "test@example.com", "mypassword", "Spokane", today);
        Post testPost = new Post("my test post", "this is my test post", today);
        
        Comment comment = new Comment("this is a test comment", today, testUser, testPost);
        commentRepository.save(comment);
        
        assertThat(commentRepository.getOne(comment.getId())).isNotNull();
        
        commentRepository.deleteById(comment.getId());
        
//        assertThat(commentRepository.getOne(comment.getId())).isNull();
        // check that the comment is deleted
        assertThrows(JpaObjectRetrievalFailureException.class, () -> {
            Comment deleted = commentRepository.getById(comment.getId());
        });
    }
}
