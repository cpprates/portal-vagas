package com.unisinos.portal_vagas.domain.service.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            setDefaultTargetUrl("/swagger-ui/index.html#/");
        }

        boolean isProfessor = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_PROFESSOR"));
        if (isProfessor) {
            setDefaultTargetUrl("/swagger-ui/index.html#/vaga-controller");
        }

        boolean isEstudante = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ESTUDANTE"));
        if (isEstudante) {
            setDefaultTargetUrl("/swagger-ui/index.html#/estudante-controller");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
