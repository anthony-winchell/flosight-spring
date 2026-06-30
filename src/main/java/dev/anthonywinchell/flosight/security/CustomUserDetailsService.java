package dev.anthonywinchell.flosight.security;

import dev.anthonywinchell.flosight.entity.Admin;
import dev.anthonywinchell.flosight.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public CustomUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .build();
    }
}
