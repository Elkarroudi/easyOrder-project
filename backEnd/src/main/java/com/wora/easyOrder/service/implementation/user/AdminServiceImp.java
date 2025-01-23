package com.wora.easyOrder.service.implementation.user;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.Admin;
import com.wora.easyOrder.mapper.GenericMapper;
import com.wora.easyOrder.mapper.contract.AdminMapper;
import com.wora.easyOrder.repository.AdminRepository;
import com.wora.easyOrder.repository.base.BaseUserRepository;
import com.wora.easyOrder.security.securityHelper.Encoder;
import com.wora.easyOrder.service.contract.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final Encoder encoder;

    @Override
    public BaseUserRepository<Admin> getRepository() {
        return adminRepository;
    }

    @Override
    public GenericMapper<Admin, UserRequestDTO, UserResponseDTO> getMapper() {
        return adminMapper;
    }

    @Override
    public Encoder getEncoder() {
        return encoder;
    }

}
