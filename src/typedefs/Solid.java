package typedefs;

import javafx.scene.shape.Rectangle;

public abstract class Solid extends MapItem {
  
  public int w;
  public int h;
  public Rectangle hitbox;
  
  public Solid(Coordinates coords) {
    super(coords);
  }
  
  public abstract void specialProperties();

}
