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
public class ImageContent {

    /**
     * Image ID for later reference
     */
    @Id
    private String id;

    /**
     * Human-readable description of image. Title or maybe actual description
     */
    private String description;

    /**
     * Image file's content // TODO revisit this and make sure data type is compatible
     */
    private Blob content;

    private Instant createdOn;

    private Instant updatedOn;
}
