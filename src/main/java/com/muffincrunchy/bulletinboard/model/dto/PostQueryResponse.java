package com.muffincrunchy.bulletinboard.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PostQueryResponse {

    private int no;
    private int id;
    private String author;
    private String password;
    private String title;
    private String body;
    private int views;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
