package com.wora.easyOrder.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequestDTO(

        @NotBlank(message = "Email is required")
        @Email(message = "Email is invalid")
        String email,

        @NotBlank(message = "Password is required")
        String password

) {
}
