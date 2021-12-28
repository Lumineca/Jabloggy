package com.jkl.jbloggy.entities.post;

import com.jkl.jbloggy.entities.ImageContentData;
import com.jkl.jbloggy.entities.comment.CommentData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.Instant;

@Data
@NoArgsConstructor
public class PostData {

    /**
     * Unique title of blog post
     */
    private String title;

    /**
     * Comment data for blog post
     */
    private Blob content;

    /**
     * Images to be used in blog post
     */
    private ImageContentData[] images;

    /**
     * Comments under blog post
     */
    private CommentData[] commentData;

    private Instant createdOn;

    private Instant updatedOn;
}
