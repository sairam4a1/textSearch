package com.assignment.textsearchservice.controller;

import com.assignment.textsearchservice.dto.CreatePostDTO;
import com.assignment.textsearchservice.dto.UpdatePostDTO;
import com.assignment.textsearchservice.model.Post;
import com.assignment.textsearchservice.service.PostService;
import com.assignment.textsearchservice.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {
    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<ApiResponse<Post>> createPost(@RequestBody @Valid CreatePostDTO dto) {
        log.info("Calling the postService to create post with {}", dto);

        return ResponseEntity.ok(new ApiResponse<>("Successfully created",
                postService.createPost(dto), HttpStatus.CREATED.value()));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Post>> updatePost(@RequestBody @Valid UpdatePostDTO dto) {
        log.info("Calling the postService to update post with {}", dto);
        return ResponseEntity.ok(new ApiResponse<>("Successfully updated",
                postService.updatePost(dto), HttpStatus.OK.value()));
    }

    @GetMapping("/{prompt}")
    public ResponseEntity<ApiResponse<List<Post>>> getAllPostsByPrompt(@PathVariable String prompt) {
        log.info("Calling the postService to retrieve  posts with prompt {}", prompt);
        return ResponseEntity.ok(new ApiResponse<>("Successfully retrieved posts",
                postService.getAllPostsByPrompt(prompt), HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Post>>> getAllPosts() {
        log.info("Calling the postService to retrieve  posts ");
        return ResponseEntity.ok(new ApiResponse<>("Successfully retrieved posts",
                postService.getAllPosts(), HttpStatus.OK.value()));
    }
}
