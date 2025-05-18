package com.codefactory.fleetguard360.service;

import com.codefactory.fleetguard360.repository.UsuarioRepository;
import com.codefactory.fleetguard360.repository.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String login(String correo, String password) {
        Usuario usuario = usuarioRepository.findByEmail(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Correo no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPasswordHash())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return jwtService.generateToken(usuario);
    }
}
