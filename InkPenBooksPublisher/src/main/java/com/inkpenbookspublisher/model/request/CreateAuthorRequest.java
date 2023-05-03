package com.inkpenbookspublisher.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAuthorRequest {
    private String name;
    private String email;
    private String biography;
}
