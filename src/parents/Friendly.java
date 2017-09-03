package parents;

import typedefs.Stats;

public abstract class Friendly extends Pokemon {

  public Friendly(String name, Stats stats, int[] moves, int type) {
    super(name, stats, moves, type, name);
  }

}
