package com.bootcamp.jwt.rest.service;

import com.bootcamp.jwt.domain.User;
import com.bootcamp.jwt.repository.UserEntity;
import com.bootcamp.jwt.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(final UserEntityRepository userEntityRepository,
                       final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User createUser(User user) throws Exception {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            UserEntity persistedUser = userEntityRepository.save(new UserEntity(user));
            return new User(persistedUser);
        } catch (Exception e) {
            throw new Exception("User Creation Failed : " + e.getMessage());
        }
    }

    public User getUser(String userName) throws Exception {
        try {
            Optional<UserEntity> systemUser = userEntityRepository.findByUsername(userName);
            if (systemUser.isPresent()) {
                return new User(systemUser.get());
            }
            throw new Exception("User Not Found !");
        } catch (Exception e) {
            throw new Exception("Something Went Wrong  : " + e.getMessage());
        }
    }

}
