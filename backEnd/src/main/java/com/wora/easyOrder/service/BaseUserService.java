package com.wora.easyOrder.service;

import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.base.BaseUser;
import com.wora.easyOrder.entity.projectEnum.UserRole;
import com.wora.easyOrder.mapper.GenericMapper;
import com.wora.easyOrder.repository.base.BaseUserRepository;
import com.wora.easyOrder.security.securityHelper.Encoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseUserService<T extends BaseUser> {

    BaseUserRepository<T> getRepository();
    GenericMapper<T, UserRequestDTO, UserResponseDTO> getMapper();
    Encoder getEncoder();

    default Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<T> entities = getRepository().findAll(pageable);
        return entities.map(getMapper()::toResponseDTO);
    };

    default T findById(String id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id : " + id));
    };

    default UserResponseDTO findByIdAndMapToResponseDTO(String id) {
        return getMapper().toResponseDTO(
                findById(id)
        );
    };

    default T findByEmail(String email) {
        return getRepository().findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Entity not found with email : " + email));
    };

    default UserResponseDTO findByEmailAndMapToResponseDTO(String email) {
        return getMapper().toResponseDTO(
                findByEmail(email)
        );
    };

    default UserResponseDTO create(UserRole role, UserRequestDTO req) {
        T entity = getMapper().toEntity(req);

        entity.setRole(role);
        entity.setPassword(
                getEncoder().password().encode(entity.getPassword())
        );
        return getMapper().toResponseDTO(
                getRepository().save(entity)
        );
    };

    default UserResponseDTO update(String id, UserRequestDTO req) {
        T entity = findById(id);
        getMapper().updateEntity(req, entity);
        getRepository().save(entity);

        return getMapper().toResponseDTO(
                getRepository().save(entity)
        );
    };

    default void delete(String id) {
        T entity = findById(id);
        getRepository().delete(entity);
    };

}
