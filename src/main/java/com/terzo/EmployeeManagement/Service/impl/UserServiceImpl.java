package com.terzo.EmployeeManagement.Service.impl;

import com.terzo.EmployeeManagement.Repository.UserRepository;
import com.terzo.EmployeeManagement.Service.UserService;
import com.terzo.EmployeeManagement.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

}
