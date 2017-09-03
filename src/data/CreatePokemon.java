package data;


import parents.Pokemon;
import pokemon.Charmander;
import pokemon.Pikachu;
import typedefs.Stats;

public class CreatePokemon {
  
  public static Pokemon createPokemon(int pokemon, Stats stats, int[] moves) {
    
    if (pokemon == 1) {
      return new Charmander(stats, moves);
    }
    else if (pokemon == 2) {
      return new Pikachu(stats, moves);
    }
    else {
      return new Pikachu(stats, moves);
    }
    
  }

}
