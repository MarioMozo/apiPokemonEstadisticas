package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer timeBet;

    @Column(nullable = false)
    private Boolean winner;

    @Column(nullable= false)
    private Integer battles;

    @Column(nullable= false)
    private Integer victories;

    @Column(nullable= false)
    private Integer defeats;



}
