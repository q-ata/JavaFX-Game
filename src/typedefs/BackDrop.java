package typedefs;

public abstract class BackDrop extends MapItem {

  public BackDrop(Coordinates coords, String s) {
    
    super(coords, s);
    
  }
  
  public abstract void specialProperties();
  
}
