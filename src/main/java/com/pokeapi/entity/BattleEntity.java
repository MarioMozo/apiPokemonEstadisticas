package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "battle")
public class BattleEntity {

    //EL ID VIENE DE JUGANDOR, LO CUAL NO SE GENERARÁ,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idBattle;





}
