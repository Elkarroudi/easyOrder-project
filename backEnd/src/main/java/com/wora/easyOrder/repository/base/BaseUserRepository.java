package com.wora.easyOrder.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseUserRepository<T> extends JpaRepository<T, String> {

    Optional<T> findByEmail(String email);

}
