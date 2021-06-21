package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

public interface UserService {

    public UserEntity addUser(UserEntity userEntity);

    public UserEntity findById(long id);
}
