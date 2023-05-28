package com.assignment.textsearchservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDTO {
    @NotEmpty(message = "id should not null or empty")
    private String id;
    @NotEmpty(message = "name should not null or empty")
    private String name;
    @NotEmpty(message = "author should not null or empty")
    private String author;
    @NotEmpty(message = "description should not null or empty")
    private String description;
}
