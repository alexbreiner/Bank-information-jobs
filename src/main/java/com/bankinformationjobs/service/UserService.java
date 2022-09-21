package com.bankinformationjobs.service;

import com.bankinformationjobs.domain.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
