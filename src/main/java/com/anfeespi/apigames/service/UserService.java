package com.anfeespi.apigames.service;

import com.anfeespi.apigames.dto.UserDTO;
import com.anfeespi.apigames.model.User;
import com.anfeespi.apigames.repository.UserRepository;
import com.anfeespi.apigames.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataMapper dataMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean createUser(UserDTO userDto) {
        User user = dataMapper.convertUserDTOToUser(userDto);
        userRepository.save(user);
        return true;
    }
}
