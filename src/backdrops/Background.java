package backdrops;

import typedefs.BackDrop;
import typedefs.Coordinates;

public class Background extends BackDrop {

  public Background(Coordinates coords) {
    
    super(coords);
    
    this.spriteLocation = "file:resources/misc/grass.png";
    this.w = 100;
    this.h = 100;
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
