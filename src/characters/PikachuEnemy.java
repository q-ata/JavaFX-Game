package characters;

import parents.Enemy;
import parents.Pokemon;
import pokemon.Pikachu;
import typedefs.Coordinates;
import typedefs.Stats;

public class PikachuEnemy extends Enemy {
  
  private static Stats[] pokemonStats = new Stats[] {new Stats(new int[] {15, 15, 12, 10, 55, 10})};
  private static Pokemon[] pokemons = new Pokemon[] {new Pikachu(pokemonStats[0], new int[] {3, 4})};

  public PikachuEnemy(Coordinates coords) {
    
    super("Pikachu", coords, pokemons, new int[][] {{20, 80}}, "/characters/pikachu.png");
    
    this.w = this.h = 30;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
