package com.iampesi.msgboard.repository;

import com.iampesi.msgboard.domain.Comment;
import com.iampesi.msgboard.domain.Post;
import com.iampesi.msgboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser(User user);
}
