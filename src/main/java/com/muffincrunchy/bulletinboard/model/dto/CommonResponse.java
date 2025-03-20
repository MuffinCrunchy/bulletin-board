package com.muffincrunchy.bulletinboard.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponse<T> {

    private int statusCode;
    private String message;
    private T data;
}
