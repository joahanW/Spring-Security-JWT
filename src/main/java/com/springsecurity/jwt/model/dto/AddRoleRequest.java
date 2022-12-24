package com.springsecurity.jwt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddRoleRequest {
    private String username;
    private String rolename;

}
