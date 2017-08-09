package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class Tree extends Solid {

  public Tree(Coordinates coords) {
    
    super(coords, "file:resources/solids/tree.png");
    
    this.w = 50;
    this.h = 78;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
