package org.example.order_management.infrastructure.rdb.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.order_management.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
