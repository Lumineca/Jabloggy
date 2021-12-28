package com.jkl.jbloggy.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
public class ImageContentData {

    /**
     * Image ID for later reference
     */
    private String id;

    /**
     * Human-readable description of image. Title or maybe actual description
     */
    private String description;

    /**
     * Image file's content // TODO revisit this and make sure data type is compatible
     */
    private Blob content;
}
