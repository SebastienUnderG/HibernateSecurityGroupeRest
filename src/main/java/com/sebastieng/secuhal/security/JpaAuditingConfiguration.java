package com.sebastieng.secuhal.security;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sebastieng.secuhal.entity.MyUser;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<MyUser> auditorProvider() {

        return () -> Optional.ofNullable((MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
