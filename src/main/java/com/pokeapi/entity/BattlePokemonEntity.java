package com.pokeapi.entity;
import jakarta.persistence.*;
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
@Table(name = "battle_pokemon")
public class BattlePokemonEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_battle", nullable = false)
        private Integer idBattle;

        @Column(nullable = false)
        private Integer battle;

        @Column(nullable = false)
        private Integer winner;

        @Column(nullable = false)
        private Integer defeat;
}
