package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class Tree extends Solid {

  public Tree(Coordinates coords) {
    
    super(coords);
    
    this.spriteLocation = "file:resources/misc/tree.png";
    this.w = 32;
    this.h = 50;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
