package com.binhnc.tmdt.service;

import com.binhnc.tmdt.model.User;

public interface UserService {
    User findByUserName(String userName);
}
