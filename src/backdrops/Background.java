package backdrops;

import typedefs.BackDrop;
import typedefs.Coordinates;

public class Background extends BackDrop {

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
