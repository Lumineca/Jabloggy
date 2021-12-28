package com.jkl.jabloggy.service;

import com.jkl.jabloggy.data.Post;
import com.jkl.jabloggy.mapping.BlogPostServiceMapper;
import com.jkl.jabloggy.repository.BlogPostRepository;
import com.jkl.jbloggy.entities.post.CreatePostRequest;
import com.jkl.jbloggy.entities.post.PostData;
import com.jkl.jbloggy.entities.post.UpdatePostRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
public class PostService {

    private BlogPostServiceMapper mapper;

    private BlogPostRepository postRepository;

    public PostData createBlogPost(CreatePostRequest request) throws Exception {
        if (postRepository.existsById(request.getTitle())) {
            throw new Exception();
        }

        final Post post = mapper.map(request);
        final Instant now = Instant.now();
        post.setCreatedOn(now);
        post.setUpdatedOn(now);

        postRepository.save(post);

        return mapper.map(post);
    }

    public PostData getBlogPost(String title) throws Exception {
        if (!postRepository.existsById(title)) {
            throw new Exception();
        }

        final Post post = postRepository.getByTitle(title);
        return mapper.map(post);
    }

    public Page<PostData> getBlogPostsPage(PageRequest pageRequest) {
        return postRepository.getAllOrderByCreatedOnDescending(pageRequest).map(mapper::map);
    }

    public PostData updateBlogPost(String title, UpdatePostRequest request) throws Exception {
        if (!postRepository.existsById(title)) {
            throw new Exception();
        }

        final Post oldPost = postRepository.getByTitle(title);
        if (!Objects.equals(oldPost.getTitle(), request.getTitle())) {
            // TODO implement new title logic, will probably need coordination with comment services
        }

        final Post updatedPost = mapper.map(request);
        updatedPost.setCreatedOn(oldPost.getCreatedOn());
        updatedPost.setUpdatedOn(Instant.now());

        postRepository.save(updatedPost);

        return mapper.map(updatedPost);
    }

    public void deleteBlogPost(String title) throws Exception {
        if (!postRepository.existsById(title)) {
            throw new Exception();
        }
        postRepository.deleteById(title);
    }

}
