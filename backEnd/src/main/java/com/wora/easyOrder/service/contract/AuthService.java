package com.wora.easyOrder.service.contract;

import com.wora.easyOrder.dto.request.AuthRequestDTO;
import com.wora.easyOrder.dto.response.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO login(AuthRequestDTO dto);
    void logout(String token);

}
