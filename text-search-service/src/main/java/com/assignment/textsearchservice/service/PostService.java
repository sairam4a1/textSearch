package com.assignment.textsearchservice.service;

import com.assignment.textsearchservice.dto.CreatePostDTO;
import com.assignment.textsearchservice.dto.UpdatePostDTO;
import com.assignment.textsearchservice.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(CreatePostDTO dto);
    Post updatePost(UpdatePostDTO updatePostDTO);
    List<Post>getAllPosts();
    List<Post>getAllPostsByPrompt(String prompt);
}
