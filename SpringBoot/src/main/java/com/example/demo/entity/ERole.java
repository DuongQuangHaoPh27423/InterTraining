package com.example.demo.entity;

import lombok.Getter;

public enum ERole {
    ROLE_ADMIN("ROLE_USER"),
    ROLE_USER("ROLE_ADMIN");
    @Getter
    private final String value;
    private ERole(String value) {
        this.value = value;
    }
}
