package com.wora.easyOrder.dto.response;

import java.time.LocalDateTime;

public record AuthResponseDTO(

        String token,
        LocalDateTime issuedAt,
        LocalDateTime expiration,
        UserResponseDTO user

) {

    public AuthResponseDTO(String token, LocalDateTime issuedAt, LocalDateTime expiration, UserResponseDTO user) {
        this.token = token;
        this.issuedAt = issuedAt;
        this.expiration = expiration;
        this.user = user;
    }

}
