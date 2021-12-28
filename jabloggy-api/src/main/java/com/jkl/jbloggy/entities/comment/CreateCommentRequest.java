package com.jkl.jbloggy.entities.comment;

import com.jkl.jbloggy.entities.ImageContentData;

import java.sql.Blob;

public class CreateCommentRequest {

    /**
     * Comment data for blog post or another comment
     */
    private Blob content;

    /**
     * Images to be used in Comment
     */
    private ImageContentData[] images;
}
