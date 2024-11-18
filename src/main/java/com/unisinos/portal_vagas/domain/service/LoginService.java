package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.model.login.LoginRequest;
import com.unisinos.portal_vagas.domain.service.authentication.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private AuthenticationManager authenticationManager;
    private UsuarioDetailService usuarioDetailService;
    private JwtService jwtService;

    public LoginService(AuthenticationManager authenticationManager, UsuarioDetailService usuarioDetailService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioDetailService = usuarioDetailService;
        this.jwtService = jwtService;
    }

    public String authenticate(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getSenha()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(usuarioDetailService.loadUserByUsername(loginRequest.getEmail()));
        } else {
            throw new UsernameNotFoundException("Usuário inválido");
        }
    }
}
