package com.jkl.jbloggy.entities.comment;

import com.jkl.jbloggy.entities.ImageContentData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.Instant;

@Data
@NoArgsConstructor
public class CommentData {

    /**
     * Unique comment identifier, possibly generated
     */
    private String id;

    /**
     * Comment data for blog post or another comment
     */
    private Blob content;

    /**
     * Images to be used in Comment
     */
    private ImageContentData[] images;

    /**
     * Nested Comment
     */
    private CommentData[] commentData;

    private Instant createdOn;

    private Instant updatedOn;
}
