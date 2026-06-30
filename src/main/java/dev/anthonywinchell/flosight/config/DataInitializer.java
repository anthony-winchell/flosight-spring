package dev.anthonywinchell.flosight.config;

import dev.anthonywinchell.flosight.entity.Admin;
import dev.anthonywinchell.flosight.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @Bean
    CommandLineRunner initAdmin(AdminRepository adminRepository,
                                PasswordEncoder passwordEncoder) {
        return args -> {
            if (adminRepository.findByUsername("admin").isEmpty()) {
                Admin admin = Admin.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .build();

                adminRepository.save(admin);
            }
        };
    }
}
