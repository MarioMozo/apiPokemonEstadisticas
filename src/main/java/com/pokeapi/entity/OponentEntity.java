package com.pokeapi.entity;

import jakarta.persistence.*;
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

    @Column(nullable= false)
    private Integer battles;

    @Column(nullable= false)
    private Integer victories;

    @Column(nullable= false)
    private Integer defeats;

    @OneToOne
    @JoinColumn(name = "pokemon_user_id", nullable = false)
    private PokemonUserEntity pokemonUser;

}
