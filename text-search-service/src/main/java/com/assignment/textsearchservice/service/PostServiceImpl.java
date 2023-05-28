package com.assignment.textsearchservice.service;

import com.assignment.textsearchservice.dto.CreatePostDTO;
import com.assignment.textsearchservice.dto.UpdatePostDTO;
import com.assignment.textsearchservice.exception.PostNotFoundException;
import com.assignment.textsearchservice.model.Post;
import com.assignment.textsearchservice.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository repository;

    @Override
    public Post createPost(CreatePostDTO dto) {
        Post post = new Post(dto);
        log.info("Successfully created post with {}", post);
        return repository.save(post);
    }

    @Override
    public Post updatePost(UpdatePostDTO updatePostDTO) {
        Optional<Post> byId = repository.findById(updatePostDTO.getId());
        if (byId.isPresent()) {
            Post post = byId.get();
            post.update(updatePostDTO);
            Post savedPost = repository.save(post);
            log.info("Successfully updated Post with {}", savedPost);
            return savedPost;
        }
        throw new PostNotFoundException("Post not found with id: " + updatePostDTO.getId());
    }

    @Override
    @Cacheable(value = "posts")
    public List<Post> getAllPosts() {
        List<Post> postList = repository.findAll();
        log.info("Successfully retrieved all posts count: {}", (long) postList.size());
        return postList;
    }

    @Override
    @Cacheable(value = "posts", key = "#prompt")
    public List<Post> getAllPostsByPrompt(String prompt) {
        String[] prompts = prompt.split(" ");
        return repository.findAllBy(new TextCriteria()
                .matchingAny(prompt), Sort.by("name", "description"));
    }
}
