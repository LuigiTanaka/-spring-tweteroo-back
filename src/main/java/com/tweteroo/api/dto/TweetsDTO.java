package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetsDTO(
    
    @NotBlank String username,

    @NotBlank String tweet) {
    
}
