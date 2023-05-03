package com.inkpenbookspublisher.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InkPenBooksResponse<T> {
    private T response;
    private boolean isSuccess;
    private String errorMessage;
}
