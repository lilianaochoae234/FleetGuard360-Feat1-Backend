package com.codefactory.fleetguard360.repository.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
    private String descripcion;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Conductor getConductorId() {
        return conductorId;
    }

    public void setConductorId(Conductor conductorId) {
        this.conductorId = conductorId;
    }
}
