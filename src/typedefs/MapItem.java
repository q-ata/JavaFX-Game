package typedefs;

public abstract class MapItem {
  
  public String spriteLocation;
  public int x;
  public int y;
  public int vx;
  public int vy;
  public int w;
  public int h;
  
  public MapItem(Coordinates coords) {
    
    this.x = coords.x;
    this.y = coords.y;
    this.vx = this.x;
    this.vy = this.y;
    
  }

}
