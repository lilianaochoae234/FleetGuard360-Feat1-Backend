package com.codefactory.fleetguard360.controller;

import com.codefactory.fleetguard360.controller.DTO.TurnoDTO;
import com.codefactory.fleetguard360.controller.DTO.TurnoResponseDTO;
import com.codefactory.fleetguard360.repository.entities.Turno;
import com.codefactory.fleetguard360.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<TurnoResponseDTO> asignarTurno(@RequestBody TurnoDTO dto) {
        TurnoResponseDTO turno = turnoService.crearTurno(dto);
        return ResponseEntity.ok(turno);
    }
}
