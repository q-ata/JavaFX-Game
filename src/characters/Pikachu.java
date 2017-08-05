package characters;

import java.util.HashMap;

import parents.Enemy;
import typedefs.Coordinates;
import typedefs.Move;
import typedefs.Stats;

public class Pikachu extends Enemy {

  public Pikachu(Coordinates coords, Stats stats, HashMap<Integer, Move> availableMoves) {
    
    super("Pikachu", coords, stats, availableMoves);
    
    this.spriteLocation = "file:resources/characters/pikachu.png";
    this.w = this.h = 30;
    
  }

}
