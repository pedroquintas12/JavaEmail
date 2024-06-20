package com.envio.email.config;

import com.envio.email.repositories.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.envio.email.repositories", repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfig {
}