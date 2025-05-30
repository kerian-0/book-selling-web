package org.example.booksellingweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager
    authenticationManager(AuthenticationConfiguration config)
    throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin( c ->{
            c.loginPage("/login")
                    .permitAll();
            c.defaultSuccessUrl("/home");
        });
        http.authorizeHttpRequests( c ->{
            c.requestMatchers("/register","/bootstrap/**","/images/books/**","/cover/**").permitAll();
            c.anyRequest().authenticated();
        });
        http.logout( c ->{
            c.logoutUrl("/logout").logoutSuccessUrl("/login");



        });
       // http.authenticationProvider(daoAuthenticationProvider());
        return http.build();
    }
}
