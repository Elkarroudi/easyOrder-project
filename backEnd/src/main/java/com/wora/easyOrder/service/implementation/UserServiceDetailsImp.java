package com.wora.easyOrder.service.implementation;

import com.wora.easyOrder.entity.base.BaseUser;
import com.wora.easyOrder.repository.base.BaseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceDetailsImp implements UserDetailsService {

    private final List<BaseUserRepository<? extends BaseUser>> userRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUser(username);
    }

    public BaseUser findUser(String username) {
        for (BaseUserRepository<? extends BaseUser> repository : userRepositories) {
            Optional<? extends BaseUser> userOptional = repository.findByEmail(username);
            if (userOptional.isPresent()) {
                return userOptional.get();
            }
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}
