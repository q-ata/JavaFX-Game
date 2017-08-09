package parents;

import typedefs.Move;
import typedefs.Stats;

public abstract class Friendly extends Pokemon {

  public Friendly(String name, Stats stats, Move[] moves, int type) {
    super(name, stats, moves, type, name);
  }

}
