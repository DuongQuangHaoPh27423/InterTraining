package com.example.demo.dto.request;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SignUpRequest {
    private String userName;
    private String password;
    private Set<String> listRoles = new HashSet<>();
}
