package pokemon;

import parents.Pokemon;
import typedefs.Move;
import typedefs.Stats;

public class Pikachu extends Pokemon {
  
  private static String name = "Pikachu";
  private static int type = 2;
  private static String battleSprite = "file:resources/characters/pikachu_battle.png";

  public Pikachu(Stats stats, Move[] moves) {
    super(name, stats, moves, type, battleSprite);
  }

}
