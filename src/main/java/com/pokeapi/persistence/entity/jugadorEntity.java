package com.pokeapi.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")

public class jugadorEntity {

    public jugadorEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokemon", nullable = false)
    private Integer idPokemon;

    @Column(nullable = false, length = 35)
    private String nombre;

    @Column(nullable = false, length = 35)
    private String nombreEstadistica;

    @Column(nullable = false)
    private Integer valorEstadistica;

    @Column(nullable = false)
    private Integer batallas;

    @Column(nullable = false)
    private Integer victorias;

    @Column(nullable = false)
    private Integer derrotas;

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEstadistica() {
        return nombreEstadistica;
    }

    public void setNombreEstadistica(String nombreEstadistica) {
        this.nombreEstadistica = nombreEstadistica;
    }

    public Integer getValorEstadistica() {
        return valorEstadistica;
    }

    public void setValorEstadistica(Integer valorEstadistica) {
        this.valorEstadistica = valorEstadistica;
    }

    public Integer getBatallas() {
        return batallas;
    }

    public void setBatallas(Integer batallas) {
        this.batallas = batallas;
    }

    public Integer getVictorias() {
        return victorias;
    }

    public void setVictorias(Integer victorias) {
        this.victorias = victorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }
}
