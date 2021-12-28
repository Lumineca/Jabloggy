package com.jkl.jabloggy.config;

import com.jkl.jabloggy.repository.BlogPostRepository;
import com.jkl.jabloggy.repository.CommentRepository;
import com.jkl.jabloggy.repository.ImageContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Autowired
    public BlogPostRepository blogPostRepository;

    @Autowired
    public ImageContentRepository imageContentRepository;

    @Autowired
    public CommentRepository commentRepository;
}
