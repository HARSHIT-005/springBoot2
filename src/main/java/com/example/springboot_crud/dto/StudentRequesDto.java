package com.example.springboot_crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequesDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 18, message = "Age should be at least 18")
    private int age;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
}
