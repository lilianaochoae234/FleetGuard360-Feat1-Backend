package com.codefactory.fleetguard360.service;

import com.codefactory.fleetguard360.repository.ConductorRepository;
import com.codefactory.fleetguard360.repository.entities.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ConductorRepository conductorRepo;

    @Autowired
    private JwtService jwtService;

    public String login(String correo, String password) {
        Conductor conductor = conductorRepo.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Correo no encontrado"));

        if (!conductor.getPassword().equals(password)) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return jwtService.generateToken(conductor);
    }
}
