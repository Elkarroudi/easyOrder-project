package com.wora.easyOrder.dto.response;

import com.wora.easyOrder.entity.projectEnum.UserRole;

public record UserResponseDTO(

        String id,
        String name,
        String email,
        String phone,
        UserRole role

) {
}
