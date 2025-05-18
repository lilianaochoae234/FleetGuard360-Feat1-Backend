package com.codefactory.fleetguard360.repository.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date inicio;
    private Date fin;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductorId;

    @OneToMany
    @JoinColumn(name = "ruta_id", nullable = false)
    private List<Ruta> rutas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Conductor getConductorId() {
        return conductorId;
    }

    public void setConductorId(Conductor conductorId) {
        this.conductorId = conductorId;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }
}
