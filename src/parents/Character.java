package parents;

import typedefs.Coordinates;

public abstract class Character {
  
  public int x;
  public int y;
  public int id;
  public String spriteLocation;
  
  public Character(Coordinates coord) {
    this.x = coord.x;
    this.y = coord.y;
  }

}
