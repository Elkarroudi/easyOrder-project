package com.wora.easyOrder.entity.base;

import com.wora.easyOrder.entity.projectEnum.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @Column(
            name = "name",
            nullable = false
    )
    protected String name;

    @Column(
            name = "email",
            nullable = false
    )
    protected String email;

    @Column(
            name = "phone",
            nullable = false
    )
    protected String phone;

    @Column(
            name = "password",
            nullable = false
    )
    protected String password;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "role",
            nullable = false
    )
    protected UserRole role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
                role.name()
        );

        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

}
