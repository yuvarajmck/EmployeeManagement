package com.terzo.EmployeeManagement.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;

    @NotEmpty(message = "This field must not be empty")
    private String name;

    @NotEmpty(message = "This field must not be empty")
    private String email;

    @NotEmpty(message = "This field must not be empty")
    private String mobileNo;

    @NotEmpty(message = "This field must not be empty")
    private String department;

    @NotEmpty(message = "This field must not be empty")
    private String photoUrl;

    private LocalDate joiningDate;
}
