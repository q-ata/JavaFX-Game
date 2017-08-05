package typedefs;

public abstract class Solid extends MapItem {
  
  public int w;
  public int h;
  
  public Solid(Coordinates coords) {
    super(coords);
  }
  
  public abstract void specialProperties();

}
