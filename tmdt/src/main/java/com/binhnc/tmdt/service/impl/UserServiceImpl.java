package com.binhnc.tmdt.service.impl;

import com.binhnc.tmdt.model.User;
import com.binhnc.tmdt.repository.UserRepository;
import com.binhnc.tmdt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
