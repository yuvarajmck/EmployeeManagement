package com.terzo.EmployeeManagement.Dto;


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

    private String name;

    private String email;

    private String mobileNo;

    private String department;

    private String photoUrl;

    private LocalDate joiningDate;
}
