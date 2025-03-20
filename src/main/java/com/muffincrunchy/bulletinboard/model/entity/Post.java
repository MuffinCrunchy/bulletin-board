package com.muffincrunchy.bulletinboard.model.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

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
