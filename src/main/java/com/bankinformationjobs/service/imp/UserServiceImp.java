package com.bankinformationjobs.service.imp;

import com.bankinformationjobs.domain.entity.User;
import com.bankinformationjobs.repository.RoleRepository;
import com.bankinformationjobs.repository.UserRepository;
import com.bankinformationjobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        if (Objects.isNull(username)) {
             throw new RuntimeException("User not found");
        }
        return userRepository.findByUsername(username);
    }
}
