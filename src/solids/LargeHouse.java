package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class LargeHouse extends Solid {

  public LargeHouse(Coordinates coords) {
    
    super(coords, "file:resources/buildings/largehouse.png");
    
    this.w = 180;
    this.h = 144;
    this.offy = 56;
    this.hity += this.offy;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
