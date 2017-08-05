package parents;

import typedefs.Coordinates;
import typedefs.MapItem;

public abstract class Character extends MapItem {
  
  public int id;
  
  public Character(Coordinates coords) {
    super(coords);
  }

}
