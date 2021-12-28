package com.jkl.jabloggy.config;

import com.jkl.jabloggy.mapping.BlogPostServiceMapper;
import com.jkl.jabloggy.repository.BlogPostRepository;
import com.jkl.jabloggy.repository.CommentRepository;
import com.jkl.jabloggy.service.BlogPostController;
import com.jkl.jabloggy.service.CommentsService;
import com.jkl.jabloggy.service.PostService;
import com.jkl.jbloggy.service.BlogPostService;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostServicesConfig {

    @Bean BlogPostServiceMapper blogPostServiceMapper() {
        return Mappers.getMapper(BlogPostServiceMapper.class);
    }

    @Bean
    public BlogPostService blogPostService(
            PostService postService,
            CommentsService commentsService) {
        return new BlogPostController(postService, commentsService);
    }

    @Bean
    public PostService postService(
            BlogPostServiceMapper mapper,
            BlogPostRepository postRepository) {
        return new PostService(mapper, postRepository);
    }

    @Bean CommentsService commentsService(
            BlogPostServiceMapper mapper,
            CommentRepository commentRepository,
            BlogPostRepository postRepository) {
        return new CommentsService(mapper, commentRepository, postRepository);
    }
}
