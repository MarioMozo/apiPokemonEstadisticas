package com.pokeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BattleId implements Serializable {
    private Integer idPlayer;
    private Integer idPokemon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleId battleId = (BattleId) o;
        return Objects.equals(idPlayer, battleId.idPlayer) && Objects.equals(idPokemon, battleId.idPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, idPokemon);
    }
}
