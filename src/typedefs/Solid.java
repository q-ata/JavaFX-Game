package typedefs;

public abstract class Solid extends MapItem {
  
  public Solid(Coordinates coords) {
    super(coords);
  }
  
  public abstract void specialProperties();

}
