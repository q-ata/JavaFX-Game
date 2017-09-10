package main;

import typedefs.Coordinates;
import typedefs.MapItem;

public class Background extends MapItem {
  
  public Background(Coordinates coords, String sprite) {
    
    super(coords, sprite);
    
    this.w = 3200;
    this.h = 2000;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
