package main;

import java.util.HashMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import parents.Character;

public class Render {
  
  public static void draw() {
    
    Canvas canvas = Main.getCanvas();
    GraphicsContext gc = Main.getGc();
    Protagonist protag = Main.getProtagonist();
    HashMap<Integer, Character> entities = Main.getEntities();
    
    Image protagSprite = new Image(Protagonist.spriteLocation);
    
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
    gc.drawImage(protagSprite, protag.x, protag.y);
    
    for (Character c : entities.values()) {
      gc.drawImage(new Image(c.spriteLocation), c.x, c.y);
    }
    
  }

}
