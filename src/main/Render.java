package main;

import backdrops.Background;
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
    Background bg = Main.bg;
    
    gc.fillRect(protag.x - 391, protag.y - 237, 800, 500);
    
    gc.drawImage(bg.sprite, protag.x - 391 + 1600, protag.y - 237 + 1000, 800, 500, 0, 0, 800, 500);
    
    for (MapItem item : Main.getMapItems()) {
      
      gc.drawImage(item.sprite, item.vx, item.vy);
      
    }
    
    gc.drawImage(new Image(Protagonist.spriteLocation), 391, 237);
    
  }

}
