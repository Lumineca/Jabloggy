package com.jkl.jabloggy.service;

import com.jkl.jabloggy.data.Comment;
import com.jkl.jabloggy.mapping.BlogPostServiceMapper;
import com.jkl.jabloggy.repository.BlogPostRepository;
import com.jkl.jabloggy.repository.CommentRepository;
import com.jkl.jbloggy.entities.comment.CommentData;
import com.jkl.jbloggy.entities.comment.CreateCommentRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.UUID;

import static com.jkl.jabloggy.data.Comment.DELIMITER;

@AllArgsConstructor
public class CommentsService {
    private BlogPostServiceMapper mapper;

    private CommentRepository commentRepository;

    private BlogPostRepository postRepository;

    public CommentData createComment(String title, CreateCommentRequest request) throws Exception {
        if (!postRepository.existsById(title)) {
            throw new Exception();
        }

        final Comment comment = mapper.map(request);
        comment.setId(title + DELIMITER + UUID.randomUUID());
        comment.setPostTitle(title);
        final Instant now = Instant.now();
        comment.setCreatedOn(now);
        comment.setUpdatedOn(now);

        commentRepository.save(comment);

        return mapper.map(comment);
    }

    public CommentData createReply(String title, String id, CreateCommentRequest request) throws Exception {
        if (!postRepository.existsById(title) || !commentRepository.existsById(id)) {
            throw new Exception();
        }

        final Comment comment = mapper.map(request);
        comment.setId(id + DELIMITER + UUID.randomUUID());
        final Instant now = Instant.now();
        comment.setCreatedOn(now);
        comment.setUpdatedOn(now);

        commentRepository.save(comment);

        return mapper.map(comment);
    }

    public Page<CommentData> getAllComments(String title, PageRequest pageRequest) throws Exception {
        if (!postRepository.existsById(title)) {
            throw new Exception();
        }

        return commentRepository.getAllByPostTitle(title, pageRequest).map(mapper::map);
    }

    public void deleteComment(String id) throws Exception {
        if (!commentRepository.existsById(id)) {
            throw new Exception();
        }

        commentRepository.deleteById(id);
    }
}
