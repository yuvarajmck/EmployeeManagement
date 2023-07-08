package com.terzo.EmployeeManagement.Service;

import com.terzo.EmployeeManagement.models.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(UserEntity user);

    void delete(long username);

    List<UserEntity> findAllUsers();
}
