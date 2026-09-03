package org.example.order_management.infrastructure.rest.dto.response;


import org.example.order_management.domain.enums.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private long id;
    private String email;
    private Role role;
}