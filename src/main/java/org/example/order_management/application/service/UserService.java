package org.example.order_management.application.service;

import org.example.order_management.application.port.input.UserLoginUseCase;
import org.example.order_management.application.port.output.UserOutput;
import org.example.order_management.domain.entity.User;
import org.example.order_management.domain.enums.Role;
import org.example.order_management.domain.exception.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserLoginUseCase {

    private final UserOutput userOutput;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserOutput userOutput, PasswordEncoder passwordEncoder) {
        this.userOutput = userOutput;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String email, String password) {
        User user = userOutput.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationException("Invalid email or password");
        }

        return user;
    }

    @Override
    public User signup(String email, String password, Role role) {
        if (userOutput.findByEmail(email).isPresent()) {
            throw new AuthenticationException("Email already in use");
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        return userOutput.save(user);
    }
}
