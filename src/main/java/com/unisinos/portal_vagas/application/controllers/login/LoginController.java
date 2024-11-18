package com.unisinos.portal_vagas.application.controllers.login;

import com.unisinos.portal_vagas.domain.data.model.login.LoginRequest;
import com.unisinos.portal_vagas.domain.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("portal-vagas/authenticate")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String authenticate(@RequestBody LoginRequest loginRequest) {
        return loginService.authenticate(loginRequest);
    }
}
