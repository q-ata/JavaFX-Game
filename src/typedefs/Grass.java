package typedefs;

public class Grass extends MapItem {

  public Grass(Coordinates coords) {
    
    super(coords, "file:resources/misc/grass.png");
    
    this.w = 32;
    this.h = 32;
    
  }

  @Override
  public void specialProperties() {
    
    // wild encounters & animation
    
    return;
    
  }

}
