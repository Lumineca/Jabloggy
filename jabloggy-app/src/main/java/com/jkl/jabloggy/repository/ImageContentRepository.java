package com.jkl.jabloggy.repository;

import com.jkl.jabloggy.data.ImageContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageContentRepository extends MongoRepository<ImageContent, String> {

}
