package com.jkl.jabloggy.service;

import com.jkl.jbloggy.entities.comment.CommentData;
import com.jkl.jbloggy.entities.comment.CreateCommentRequest;
import com.jkl.jbloggy.entities.post.CreatePostRequest;
import com.jkl.jbloggy.entities.post.PostData;
import com.jkl.jbloggy.entities.post.UpdatePostRequest;
import com.jkl.jbloggy.service.BlogPostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@AllArgsConstructor
public class BlogPostController implements BlogPostService {

    private PostService postService;
    private CommentsService commentsService;

    @Override
    public PostData createBlogPost(CreatePostRequest postRequest) throws Exception {
        return postService.createBlogPost(postRequest);
    }

    @Override
    public PostData getPost(String title) throws Exception {
        return postService.getBlogPost(title);
    }

    @Override
    public Page<PostData> getAllPosts(PageRequest pageRequest) throws Exception {
        return postService.getBlogPostsPage(pageRequest);
    }

    @Override
    public PostData updatePost(String title, UpdatePostRequest postData) throws Exception {
        return postService.updateBlogPost(title, postData);
    }

    @Override
    public void deletePost(String title) throws Exception {
        postService.deleteBlogPost(title);
    }

    @Override
    public CommentData createComment(String postTitle, CreateCommentRequest commentRequest) throws Exception {
        return commentsService.createComment(postTitle, commentRequest);
    }

    @Override
    public CommentData replyComment(String title, String commentId, CreateCommentRequest commentRequest) throws Exception {
        return commentsService.createReply(title, commentId, commentRequest);
    }

    @Override
    public Page<CommentData> getComments(String title, PageRequest pageRequest) throws Exception {
        return commentsService.getAllComments(title, pageRequest);
    }

    @Override
    public void deleteComment(String commentId) throws Exception {
        commentsService.deleteComment(commentId);
    }
}
