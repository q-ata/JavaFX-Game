package typedefs;

public abstract class Solid extends MapItem {
  
  public Solid(Coordinates coords, String s) {
    
    super(coords, s);
    
  }
  
  public abstract void specialProperties();

}
