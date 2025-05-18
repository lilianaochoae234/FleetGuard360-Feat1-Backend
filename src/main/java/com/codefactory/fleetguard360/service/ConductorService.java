package com.codefactory.fleetguard360.service;


import com.codefactory.fleetguard360.controller.DTO.ConductorDTO;
import com.codefactory.fleetguard360.mapper.ConductorMapper;
import com.codefactory.fleetguard360.repository.ConductorRepository;
import com.codefactory.fleetguard360.repository.UsuarioRepository;
import com.codefactory.fleetguard360.repository.entities.Conductor;
import com.codefactory.fleetguard360.repository.entities.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {
    private final ConductorRepository conductorRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConductorMapper conductorMapper;
    private final PasswordEncoder passwordEncoder;

    public ConductorService(ConductorRepository conductorRepository, UsuarioRepository usuarioRepository, ConductorMapper conductorMapper, PasswordEncoder passwordEncoder) {
        this.conductorRepository = conductorRepository;
        this.usuarioRepository = usuarioRepository;
        this.conductorMapper = conductorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ConductorDTO crear(ConductorDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        usuario.setRol("CONDUCTOR");
        usuario.setIntentosFallidos(0);
        usuario.setBloqueoHasta(null);

        usuario = usuarioRepository.save(usuario);

        Conductor conductor = new Conductor();
        conductor.setNombre(dto.getNombre());
        conductor.setDocumentoIdentidad(dto.getDocumentoIdentidad());
        conductor.setTelefono(dto.getTelefono());
        conductor.setUsuario(usuario);

        conductor = conductorRepository.save(conductor);

        dto.setId(conductor.getId());
        dto.setPassword(null);
        return dto;
    }

    public ConductorDTO actualizar(int id, ConductorDTO dto) {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        conductorMapper.updateConductorFromDto(dto, conductor);

        conductorRepository.save(conductor);

        return dto;
    }

    public void eliminar(int id) {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        conductorRepository.deleteById(id);
        usuarioRepository.deleteById(conductor.getUsuario().getId());
    }

}
