package main;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import parents.Character;
import typedefs.Solid;

public class Render {
  
  public static void draw() {
    
    Canvas canvas = Main.getCanvas();
    GraphicsContext gc = Main.getGc();
    Protagonist protag = Main.getProtagonist();
    HashMap<Integer, Character> entities = Main.getEntities();
    Solid[] solids = Main.getSolids();
    ArrayList<Solid> visibleSolids = new ArrayList<Solid>();
    
    for (Solid solid : solids) {
      if (solid.vx > -solid.w && solid.vx < 500) {
        visibleSolids.add(solid);
      }
    }
    
    
    Image protagSprite = new Image(Protagonist.spriteLocation);
    
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
    gc.drawImage(protagSprite, protag.vx, protag.vy);
    
    for (Character c : entities.values()) {
      gc.drawImage(new Image(c.spriteLocation), c.x, c.y);
    }
    
    for (Solid item : visibleSolids) {
      gc.drawImage(new Image(item.spriteLocation), item.vx, item.vy);
    }
    
  }

}
