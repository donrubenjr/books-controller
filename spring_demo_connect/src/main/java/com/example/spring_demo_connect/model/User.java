package com.example.spring_demo_connect.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Min(18)
    @Max(60)
    private int age;
    @Email
    private String email;
    @NotNull
    private String address;
}
