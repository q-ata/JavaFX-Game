package typedefs;

public abstract class Solid extends MapItem {
  
  public int offx = 0;
  public int offy = 0;
  public int hitx;
  public int hity;
  
  public Solid(Coordinates coords, String s) {
    
    super(coords, s);
    
    this.hitx = this.x;
    this.hity = this.y;
    
  }

}
