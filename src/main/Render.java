package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import typedefs.MapItem;

public class Render {
  
  public static void draw() {
    
    Protagonist protag = Main.getProtagonist();
    if (protag.frozen) {
      return;
    }
    
    Canvas canvas = Main.getCanvas();
    GraphicsContext gc = Main.getGc();
    Image protagSprite = new Image(Protagonist.spriteLocation);
    
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
    for (MapItem item : Main.getMapItems()) {
      
      gc.drawImage(new Image(item.spriteLocation), item.vx, item.vy);
      
    }
    
    gc.drawImage(protagSprite, protag.vx, protag.vy);
    
  }

}
