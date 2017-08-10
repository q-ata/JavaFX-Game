package typedefs;

import javafx.scene.image.Image;

public abstract class MapItem {
  
  public int x;
  public int y;
  public int vx;
  public int vy;
  public int w;
  public int h;
  public Image sprite;
  
  public MapItem(Coordinates coords, String spriteLocation) {
    
    this.x = coords.x;
    this.y = coords.y;
    this.vx = this.x;
    this.vy = this.y;
    this.sprite = new Image(spriteLocation);
    
  }
  
  public abstract void specialProperties();

}
