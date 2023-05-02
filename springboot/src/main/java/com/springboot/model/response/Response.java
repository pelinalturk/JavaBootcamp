package com.springboot.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
    private T response;
    private boolean isSuccess;
    private String errorMessage;

}