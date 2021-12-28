package com.jkl.jabloggy.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Blob;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    public static final String DELIMITER = "?";

    /**
     * Unique comment identifier, possibly generated
     */
    @Id
    private String id;

    /**
     * Comment data for blog post or another comment
     */
    private Blob content;

    /**
     * Images to be used in Comment
     */
    private ImageContent[] images;

    /**
     * Nested Comment
     */
    private Comment[] commentData;

    /**
     * Post Title apllicable to
     */
    private String postTitle;

    private Instant createdOn;

    private Instant updatedOn;
}
