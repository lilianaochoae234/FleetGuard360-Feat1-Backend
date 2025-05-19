package com.codefactory.fleetguard360.mapper;

import com.codefactory.fleetguard360.controller.DTO.ConductorDTO;
import com.codefactory.fleetguard360.controller.DTO.RutaDTO;
import com.codefactory.fleetguard360.controller.DTO.TurnoResponseDTO;
import com.codefactory.fleetguard360.controller.DTO.UsuarioDTO;
import com.codefactory.fleetguard360.repository.entities.Conductor;
import com.codefactory.fleetguard360.repository.entities.Ruta;
import com.codefactory.fleetguard360.repository.entities.Turno;
import com.codefactory.fleetguard360.repository.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoMapper INSTANCE = Mappers.getMapper(TurnoMapper.class);

    @Mapping(target = "conductor", source = "conductorId")  // explícito
    @Mapping(target = "ruta", source = "ruta")
    TurnoResponseDTO turnoToTurnoResponseDTO(Turno turno);

    ConductorDTO conductorToConductorDTO(Conductor conductor);

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    RutaDTO rutaToRutaDTO(Ruta ruta);
}
