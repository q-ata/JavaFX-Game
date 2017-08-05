package main;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import parents.Enemy;
import typedefs.Solid;

public class Render {
  
  public static void draw() {
    
    Protagonist protag = Main.getProtagonist();
    if (protag.frozen) {
      return;
    }
    
    Canvas canvas = Main.getCanvas();
    GraphicsContext gc = Main.getGc();
    Solid[] solids = Main.getSolids();
    Enemy[] enemies = Main.getEnemies();
    ArrayList<Solid> visibleSolids = new ArrayList<Solid>();
    
    for (Solid solid : solids) {
      if (solid.vx > -solid.w && solid.vx < 500) {
        visibleSolids.add(solid);
      }
    }
    
    
    Image protagSprite = new Image(Protagonist.spriteLocation);
    
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
    gc.drawImage(protagSprite, protag.vx, protag.vy);
    
    for (Enemy enemy : enemies) {
      gc.drawImage(new Image(enemy.spriteLocation), enemy.vx, enemy.vy);
    }
    
    for (Solid item : visibleSolids) {
      gc.drawImage(new Image(item.spriteLocation), item.vx, item.vy);
    }
    
  }

}
