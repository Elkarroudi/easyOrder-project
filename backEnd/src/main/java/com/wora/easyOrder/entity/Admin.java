package com.wora.easyOrder.entity;

import com.wora.easyOrder.entity.base.BaseUser;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity(name = "admins")
@EqualsAndHashCode(callSuper = true)
public class Admin extends BaseUser {

}
