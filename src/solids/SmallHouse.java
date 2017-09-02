package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class SmallHouse extends Solid {

  public SmallHouse(Coordinates coords) {
    
    super(coords, "/buildings/smallhouse.png");
    
    this.w = 133;
    this.h = 126;
    this.offy = 22;
    this.hity += this.offy;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
