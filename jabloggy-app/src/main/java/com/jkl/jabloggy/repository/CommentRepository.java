package com.jkl.jabloggy.repository;

import com.jkl.jabloggy.data.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
    Page<Comment> getAllByPostTitle(String postTitle, PageRequest request);
}
