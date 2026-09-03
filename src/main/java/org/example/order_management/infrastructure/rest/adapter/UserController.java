package org.example.order_management.infrastructure.rest.adapter;

import org.example.order_management.application.port.input.UserLoginUseCase;
import org.example.order_management.domain.entity.User;
import org.example.order_management.infrastructure.rest.dto.request.LoginRequest;
import org.example.order_management.infrastructure.rest.dto.request.SignupRequest;
import org.example.order_management.infrastructure.rest.dto.response.UserResponse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserLoginUseCase userLoginUseCase;

    public UserController(UserLoginUseCase userLoginUseCase) {
        this.userLoginUseCase = userLoginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userLoginUseCase.login(loginRequest.email(), loginRequest.password());

        return ResponseEntity.ok(
                UserResponse
                        .builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@Valid @RequestBody SignupRequest signupRequest) {
        User user = userLoginUseCase.signup(signupRequest.email(), signupRequest.password(),
                signupRequest.role());

        return ResponseEntity.ok(
                UserResponse
                        .builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build());
    }
}