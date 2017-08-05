package characters;

import moves.Ember;
import moves.Thunderbolt;
import parents.Enemy;
import parents.Pokemon;
import pokemon.Pikachu;
import typedefs.Coordinates;
import typedefs.Move;
import typedefs.Stats;

public class PikachuEnemy extends Enemy {
  
  private Coordinates coords = new Coordinates(120, 120);
  private static Stats[] pokemonStats = new Stats[] {new Stats(new int[] {15, 15, 12, 10, 55, 10})};
  private static Pokemon[] pokemons = new Pokemon[] {new Pikachu(pokemonStats[0], new Move[] {new Ember(), new Thunderbolt()})};

  public PikachuEnemy(Coordinates coords) {
    
    super("Pikachu", coords, pokemons, new int[][] {{20, 80}});
    
    this.spriteLocation = "file:resources/characters/pikachu.png";
    this.w = this.h = 30;
    
  }

  public Coordinates getCoords() {
    return coords;
  }

  public void setCoords(Coordinates coords) {
    this.coords = coords;
  }

}
