package com.wora.easyOrder.service.implementation.user;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.DeliveryMan;
import com.wora.easyOrder.mapper.GenericMapper;
import com.wora.easyOrder.mapper.contract.DeliveryManMapper;
import com.wora.easyOrder.repository.DeliveryManRepository;
import com.wora.easyOrder.repository.base.BaseUserRepository;
import com.wora.easyOrder.security.securityHelper.Encoder;
import com.wora.easyOrder.service.contract.DeliveryManService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryManServiceImp implements DeliveryManService {

    private final DeliveryManRepository deliveryManRepository;
    private final DeliveryManMapper deliveryManMapper;
    private final Encoder encoder;

    @Override
    public BaseUserRepository<DeliveryMan> getRepository() {
        return deliveryManRepository;
    }

    @Override
    public GenericMapper<DeliveryMan, UserRequestDTO, UserResponseDTO> getMapper() {
        return deliveryManMapper;
    }

    @Override
    public Encoder getEncoder() {
        return encoder;
    }

}
