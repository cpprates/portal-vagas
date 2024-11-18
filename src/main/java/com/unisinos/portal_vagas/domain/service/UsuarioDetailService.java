package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.domain.data.model.professor.Professor;
import com.unisinos.portal_vagas.domain.repositories.estudante.EstudanteRepository;
import com.unisinos.portal_vagas.domain.repositories.professor.ProfessorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDetailService implements UserDetailsService {

    private final EstudanteRepository estudanteRepository;
    private final ProfessorRepository professorRepository;

    public UsuarioDetailService(EstudanteRepository estudanteRepository, ProfessorRepository professorRepository) {
        this.estudanteRepository = estudanteRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Estudante> estudante = estudanteRepository.buscarPorEmail(username);

        if (estudante.isEmpty()){
            Optional<Professor> professor = professorRepository.buscarPorEmail(username);

            if (professor.isEmpty()) {
                throw new UsernameNotFoundException("Usuario nao encontrado");
            } else {
                return User.builder()
                        .username(professor.get().getEmail())
                        .password(professor.get().getSenha())
                        .roles(professor.get().getRole())
                        .build();
            }
        } else {
            return User.builder()
                    .username(estudante.get().getEmail())
                    .password(estudante.get().getSenha())
                    .roles(estudante.get().getRole())
                    .build();
        }
    }
}
