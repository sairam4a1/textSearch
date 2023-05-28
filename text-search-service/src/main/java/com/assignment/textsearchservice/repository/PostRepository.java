package com.assignment.textsearchservice.repository;

import com.assignment.textsearchservice.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllBy(TextCriteria criteria, Sort sort);

}
