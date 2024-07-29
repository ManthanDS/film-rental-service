package com.sprinProject.data.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class ApplicationConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().
                username("MANTHAN")
                .password(passwordEncoder().encode("ROOT")).roles("ADMIN").
                build();
        UserDetails user2 = User.builder().
                username("VIDD")
                .password(passwordEncoder().encode("ROOT")).roles("ADMIN").
                build();
        UserDetails user3 = User.builder().
                username("BUDDHI")
                .password(passwordEncoder().encode("ROOT")).roles("ADMIN").
                build();
        UserDetails user4 = User.builder().
                username("KARTIK")
                .password(passwordEncoder().encode("ROOT")).roles("ADMIN").
                build();
        UserDetails user5 = User.builder().
                username("SUPRIYA")
                .password(passwordEncoder().encode("ROOT")).roles("ADMIN").
                build();
        UserDetails user6 = User.builder().
                username("RUTUJA")
                .password(passwordEncoder().encode("ROOT")).roles("CLIENT").
                build();
        return new InMemoryUserDetailsManager(user1,user2,user3,user4,user5,user6);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
