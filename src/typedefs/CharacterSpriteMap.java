package typedefs;

import javafx.scene.image.Image;

public class CharacterSpriteMap {
  
  public Image[] up;
  public Image[] down;
  public Image[] right;
  public Image[] left;
  
  public CharacterSpriteMap(String[] paths) {
    
    this.up= new Image[paths.length];
    this.down = new Image[paths.length];
    this.right = new Image[paths.length];
    this.left = new Image[paths.length];
    
    for (int i = 0; i < paths.length; i++) {
      this.up[i] = new Image(paths[i].replace("DIR", "up"));
      this.down[i] = new Image(paths[i].replace("DIR", "down"));
      this.right[i] = new Image(paths[i].replace("DIR", "right"));
      this.left[i] = new Image(paths[i].replace("DIR", "left"));
    }
    
  }

}
