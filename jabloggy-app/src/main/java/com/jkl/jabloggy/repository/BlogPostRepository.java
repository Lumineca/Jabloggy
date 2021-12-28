package com.jkl.jabloggy.repository;

import com.jkl.jabloggy.data.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<Post, String> {

    Post getByTitle(String title);

    Page<Post> getAllOrderByCreatedOnDescending(PageRequest request);
}
