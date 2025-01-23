package com.wora.easyOrder.service.implementation.user;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.Customer;
import com.wora.easyOrder.mapper.GenericMapper;
import com.wora.easyOrder.mapper.contract.CustomerMapper;
import com.wora.easyOrder.repository.CustomerRepository;
import com.wora.easyOrder.repository.base.BaseUserRepository;
import com.wora.easyOrder.security.securityHelper.Encoder;
import com.wora.easyOrder.service.contract.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final Encoder encoder;

    @Override
    public BaseUserRepository<Customer> getRepository() {
        return customerRepository;
    }

    @Override
    public GenericMapper<Customer, UserRequestDTO, UserResponseDTO> getMapper() {
        return customerMapper;
    }

    @Override
    public Encoder getEncoder() {
        return encoder;
    }

}
