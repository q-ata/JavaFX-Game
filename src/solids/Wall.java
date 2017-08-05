package solids;

import javafx.scene.shape.Rectangle;
import typedefs.Coordinates;
import typedefs.Solid;

public class Wall extends Solid {
  
  public Wall(Coordinates coords) {
    
    super(coords);
    
    this.spriteLocation = "file:resources/solids/wall.png";
    
    this.w = 30;
    this.h = 30;
    
    this.hitbox = new Rectangle(h, w, x, y);
    
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
