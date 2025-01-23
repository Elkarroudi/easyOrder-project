package com.wora.easyOrder.service.implementation;

import com.wora.easyOrder.dto.request.AuthRequestDTO;
import com.wora.easyOrder.dto.response.AuthResponseDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.base.BaseUser;
import com.wora.easyOrder.security.securityHelper.JwtService;
import com.wora.easyOrder.service.contract.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceIml implements AuthService {

    private final UserServiceDetailsImp userServiceDetailsImp;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponseDTO login(AuthRequestDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(), dto.password()
                )
        );


        BaseUser user = userServiceDetailsImp.findUser(dto.email());
        LocalDateTime tokenIssuedAt = LocalDateTime.now();

        return new AuthResponseDTO(
                jwtService.generateToken(user),
                tokenIssuedAt,
                tokenIssuedAt.plusDays(1),
                new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getRole()
                )
        );
    }

    @Override
    public void logout(String token) {

    }

}
