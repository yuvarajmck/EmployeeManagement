package com.terzo.EmployeeManagement.Dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
        private long id;

        @NotEmpty(message = "This field could not be empty")
        private String username;
        @NotEmpty(message = "This field could not be empty")
        private String password;
}
