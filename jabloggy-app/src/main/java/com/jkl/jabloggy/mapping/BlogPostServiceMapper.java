package com.jkl.jabloggy.mapping;

import com.jkl.jabloggy.data.Comment;
import com.jkl.jabloggy.data.ImageContent;
import com.jkl.jabloggy.data.Post;
import com.jkl.jbloggy.entities.ImageContentData;
import com.jkl.jbloggy.entities.comment.CommentData;
import com.jkl.jbloggy.entities.comment.CreateCommentRequest;
import com.jkl.jbloggy.entities.post.CreatePostRequest;
import com.jkl.jbloggy.entities.post.PostData;
import com.jkl.jbloggy.entities.post.UpdatePostRequest;
import org.mapstruct.Mapper;

@Mapper
public interface BlogPostServiceMapper {

    Post map(PostData postData);

    PostData map(Post post);

    Post map(CreatePostRequest postRequest);

    Post map(UpdatePostRequest postRequest);

    Comment map(CommentData commentData);

    CommentData map(Comment comment);

    Comment map(CreateCommentRequest commentRequest);

    ImageContent map(ImageContentData imageContentData);

    ImageContentData map(ImageContent imageContent);
}
