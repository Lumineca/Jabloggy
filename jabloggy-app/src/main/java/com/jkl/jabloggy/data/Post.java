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
public class Post {

    /**
     * Unique title of blog post
     */
    @Id
    private String title;

    /**
     * Comment data for blog post
     */
    private Blob content;

    /**
     * Images to be used in blog post
     */
    private ImageContent[] images;

//    /**
//     * Comments under blog post
//     */
//    private Comment[] commentData;

    private Instant createdOn;

    private Instant updatedOn;
}
