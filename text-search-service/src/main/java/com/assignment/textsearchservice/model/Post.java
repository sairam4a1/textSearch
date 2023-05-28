package com.assignment.textsearchservice.model;

import com.assignment.textsearchservice.dto.CreatePostDTO;
import com.assignment.textsearchservice.dto.UpdatePostDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post implements Serializable {
    @Id
    private String id = UUID.randomUUID().toString();
    @TextIndexed
    private String name;
    private String author;
    @TextIndexed
    private String description;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
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
