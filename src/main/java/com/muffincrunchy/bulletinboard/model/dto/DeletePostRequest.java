package com.muffincrunchy.bulletinboard.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletePostRequest {

    private int id;
    private String password;
}
