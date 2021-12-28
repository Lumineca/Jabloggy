package com.jkl.jbloggy.service;

import com.jkl.jbloggy.entities.comment.CommentData;
import com.jkl.jbloggy.entities.comment.CreateCommentRequest;
import com.jkl.jbloggy.entities.post.CreatePostRequest;
import com.jkl.jbloggy.entities.post.PostData;
import com.jkl.jbloggy.entities.post.UpdatePostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import static com.jkl.jbloggy.service.BlogPostService.BLOG_POST_URL;

@RestController
@RequestMapping(path = BLOG_POST_URL)
public interface BlogPostService {

    String BLOG_POST_URL = "posts";

    String TITLE_VARIABLE_PATH = "/{title}/";
    String COMMENT_PATH = "comments";
    String COMMENT_ID_VARIABLE_PATH = "/{comment-id}/";

    String TITLE = "title";
    String COMMENT_ID = "comment-id";

    @PostMapping
    PostData createBlogPost(CreatePostRequest postRequest) throws Exception;

    @GetMapping(value = TITLE_VARIABLE_PATH)
    PostData getPost(@PathVariable(TITLE) String title) throws Exception;

    @GetMapping
    Page<PostData> getAllPosts(PageRequest pageRequest) throws Exception;

    @PutMapping(value = TITLE_VARIABLE_PATH)
    PostData updatePost(@PathVariable(TITLE) String title, UpdatePostRequest postData) throws Exception;

    @DeleteMapping(value = TITLE_VARIABLE_PATH)
    void deletePost(@PathVariable(TITLE) String title) throws Exception;

    @PostMapping(value = TITLE_VARIABLE_PATH + COMMENT_PATH)
    CommentData createComment(@PathVariable(TITLE) String postTitle, CreateCommentRequest commentRequest) throws Exception;

    @PostMapping(value = TITLE_VARIABLE_PATH + COMMENT_PATH + COMMENT_ID_VARIABLE_PATH)
    CommentData replyComment(@PathVariable(TITLE) String title, @PathVariable(COMMENT_ID) String commentId, CreateCommentRequest commentRequest) throws Exception;

    @GetMapping(value = TITLE_VARIABLE_PATH + COMMENT_PATH)
    Page<CommentData> getComments(@PathVariable(TITLE) String title, PageRequest pageRequest) throws Exception;

    @DeleteMapping(value = COMMENT_ID_VARIABLE_PATH)
    void deleteComment(@PathVariable(COMMENT_ID) String commentId) throws Exception;
}
