package typedefs;

public abstract class MapItem {
  
  public String spriteLocation;
  public int x;
  public int y;
  
  public MapItem(Coordinates coords) {
    this.x = coords.x;
    this.y = coords.y;
  }

}
