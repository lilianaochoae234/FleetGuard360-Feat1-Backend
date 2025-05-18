package com.codefactory.fleetguard360.controller;

import com.codefactory.fleetguard360.controller.DTO.ConductorDTO;
import com.codefactory.fleetguard360.service.ConductorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ConductorDTO> crear(@RequestBody ConductorDTO dto) {
        ConductorDTO creado = conductorService.crear(dto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConductorDTO> actualizar(@PathVariable int id, @RequestBody ConductorDTO dto) {
        ConductorDTO actualizado = conductorService.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        conductorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
