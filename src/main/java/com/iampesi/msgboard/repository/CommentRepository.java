package com.iampesi.msgboard.repository;

import com.iampesi.msgboard.domain.Comment;
import com.iampesi.msgboard.domain.Post;
import com.iampesi.msgboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByUser(User user);
    List<Comment> findCommentsByPost(Post post);
}
