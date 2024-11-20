package com.unisinos.portal_vagas.application.config;

import com.unisinos.portal_vagas.domain.service.UsuarioDetailService;
import com.unisinos.portal_vagas.domain.service.authentication.AuthenticationSuccessHandler;
import com.unisinos.portal_vagas.domain.service.authentication.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioDetailService usuarioDetailService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UsuarioDetailService usuarioDetailService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.usuarioDetailService = usuarioDetailService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers(HttpMethod.GET, "portal-vagas/vagas/**").permitAll();
                    registry.requestMatchers(HttpMethod.POST,
                            "portal-vagas/estudantes/v1/estudantes",
                            "portal-vagas/professores/v1/professores",
                            "portal-vagas/authenticate").permitAll();
                    registry.requestMatchers(
                            "portal-vagas/professores/**",
                            "portal-vagas/vagas/**").hasRole("PROFESSOR");
                    registry.requestMatchers("portal-vagas/estudantes/v1/estudantes/{id}/**").hasRole("ESTUDANTE");
                    registry.requestMatchers("portal-vagas/**").hasRole("ADMIN");
                    registry.anyRequest().authenticated();
                }).formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .successHandler(new AuthenticationSuccessHandler())
                            .permitAll();
                })
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return usuarioDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}