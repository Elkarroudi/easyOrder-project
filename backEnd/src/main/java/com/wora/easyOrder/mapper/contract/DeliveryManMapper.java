package com.wora.easyOrder.mapper.contract;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.DeliveryMan;
import com.wora.easyOrder.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryManMapper extends GenericMapper<DeliveryMan, UserRequestDTO, UserResponseDTO> {
}
