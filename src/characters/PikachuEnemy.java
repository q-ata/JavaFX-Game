package characters;

import moves.IronTail;
import moves.Thunderbolt;
import parents.Enemy;
import parents.Pokemon;
import pokemon.Pikachu;
import typedefs.Coordinates;
import typedefs.Move;
import typedefs.Stats;

public class PikachuEnemy extends Enemy {
  
  private static Stats[] pokemonStats = new Stats[] {new Stats(new int[] {15, 15, 12, 10, 55, 10})};
  private static Pokemon[] pokemons = new Pokemon[] {new Pikachu(pokemonStats[0], new Move[] {new IronTail(), new Thunderbolt()})};

  public PikachuEnemy(Coordinates coords) {
    
    super("Pikachu", coords, pokemons, new int[][] {{20, 80}}, "/characters/pikachu.png");
    
    this.w = this.h = 30;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
