package characters;

import parents.Enemy;
import parents.Pokemon;
import typedefs.Coordinates;

public class CharmanderEnemy extends Enemy {

  public CharmanderEnemy(String enemyName, Coordinates coord, Pokemon[] pokemon, int[][] moveChances, String s) {
    
    super(enemyName, coord, pokemon, moveChances, s);
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
