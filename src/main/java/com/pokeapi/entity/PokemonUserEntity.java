package com.pokeapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_pokemon")
public class PokemonUserEntity {

    @Id
    @Column(name = "id_user_pokemon", nullable = false)
    private Integer idUserPokemon;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 50)
    private String moves;

    @Column(nullable = false)
    private Integer hp;

    @Column(nullable = false)
    private Boolean winner;

    @Column(nullable= false)
    private Integer battles;

    @Column(nullable= false)
    private Integer victories;

    @Column(nullable= false)
    private Integer defeats;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne(mappedBy = "pokemonUser", cascade = CascadeType.ALL)
    private OponentEntity oponent;
}
