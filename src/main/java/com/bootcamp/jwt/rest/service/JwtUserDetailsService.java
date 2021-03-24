package com.bootcamp.jwt.rest.service;

import com.bootcamp.jwt.repository.UserEntity;
import com.bootcamp.jwt.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public JwtUserDetailsService(final UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByUsername(username);
        if (user.isPresent()) {
            return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("User Not Found For Username : " + username);
    }

}
