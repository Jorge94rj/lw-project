package com.leafware.lwtemplate.service;

import com.leafware.lwtemplate.exception.EmailAlreadyExistsException;
import com.leafware.lwtemplate.model.User;
import com.leafware.lwtemplate.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }catch (Exception e) {
            throw new EmailAlreadyExistsException("Email " + user.getUsername() + " already registered");
        }
    }
}
