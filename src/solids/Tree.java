package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class Tree extends Solid {

  public Tree(Coordinates coords) {
    
    super(coords, "file:resources/solids/tree.png");
    
    this.w = 50;
    this.h = 48;
    this.offy = 30;
    this.hity += this.offy;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
