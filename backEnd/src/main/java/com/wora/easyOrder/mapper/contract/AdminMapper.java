package com.wora.easyOrder.mapper.contract;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.Admin;
import com.wora.easyOrder.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends GenericMapper<Admin, UserRequestDTO, UserResponseDTO> {
}
