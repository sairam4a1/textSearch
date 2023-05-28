package com.assignment.textsearchservice.model;

import com.assignment.textsearchservice.dto.CreatePostDTO;
import com.assignment.textsearchservice.dto.UpdatePostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post {
    @Id
    private String id = UUID.randomUUID().toString();
    @TextIndexed
    private String name;
    private String author;
    @TextIndexed
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

    public Post(CreatePostDTO dto) {
        this.name = dto.getName();
        this.author = dto.getAuthor();
        this.description = dto.getDescription();

    }

    public void update(UpdatePostDTO dto) {
        this.name = dto.getName();
        this.author = dto.getAuthor();
        this.description = dto.getDescription();
    }
}
