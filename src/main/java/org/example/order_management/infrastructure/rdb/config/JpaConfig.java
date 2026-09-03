package org.example.order_management.infrastructure.rdb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.order_management.infrastructure.rdb.repository")
public class JpaConfig {
}
