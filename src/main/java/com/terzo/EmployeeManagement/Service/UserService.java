package com.terzo.EmployeeManagement.Service;

import com.terzo.EmployeeManagement.Dto.RegistrationDto;
import com.terzo.EmployeeManagement.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
