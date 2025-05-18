package com.codefactory.fleetguard360.repository.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Licencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numero;
    private Date fechaExpiracion;
    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Conductor getConductorId() {
        return conductorId;
    }

    public void setConductorId(Conductor conductorId) {
        this.conductorId = conductorId;
    }
}
