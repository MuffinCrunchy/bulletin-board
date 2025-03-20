package com.muffincrunchy.bulletinboard.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePostRequest {

    private String author;
    private String password;
    private String title;
    private String body;
}
