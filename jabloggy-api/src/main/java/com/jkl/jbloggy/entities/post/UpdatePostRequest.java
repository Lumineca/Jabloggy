package com.jkl.jbloggy.entities.post;

import com.jkl.jbloggy.entities.ImageContentData;
import lombok.Data;

import java.sql.Blob;

@Data
public class UpdatePostRequest {

    private String title;

    private Blob content;

    private ImageContentData[] images;
}
