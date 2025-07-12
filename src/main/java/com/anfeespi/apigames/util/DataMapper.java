package com.anfeespi.apigames.util;

import com.anfeespi.apigames.dto.UserDTO;
import com.anfeespi.apigames.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataMapper() {
    }

    public User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.username(), passwordEncoder.encode(userDTO.password()));
    }
}
