package solids;

import typedefs.Coordinates;
import typedefs.Solid;

public class Wall extends Solid {
  
  public Wall(Coordinates coords) {
    
    super(coords, "/solids/wall.png");
    
    this.w = 30;
    this.h = 30;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
