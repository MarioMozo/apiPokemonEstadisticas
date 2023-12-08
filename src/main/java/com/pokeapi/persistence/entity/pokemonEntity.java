package com.pokeapi.persistence.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "jugador")


public class pokemonEntity {

    public pokemonEntity(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador", nullable = false)
    private Integer idjugador;


    @Column(nullable = false, length = 35)
    private String nombre;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer batallas;

    @Column(nullable = false)
    private Integer victorias;

    @Column(nullable = false)
    private Integer derrotas;

    public Integer getBatallas() {
        return batallas;
    }

    public void setBatallas(Integer batallas) {
        this.batallas = batallas;
    }

}
