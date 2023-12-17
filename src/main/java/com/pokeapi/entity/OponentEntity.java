package com.pokeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oponent")
public class OponentEntity {
    @Id
    @Column(name = "id_oponent", nullable = false)
    private Integer idOponent;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 25)
    private String type;

    @Column(nullable = false )
    private Integer hp;

    @Column(nullable = false)
    private Boolean winner;

}