package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import parents.Enemy;

public class Battle {
  
  public Battle(Protagonist protag, Enemy enemy) {
    
    Canvas canvas = Main.getCanvas();
    GraphicsContext gc = Main.getGc();
    
    protag.frozen = true;
    
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canvas.getHeight(), canvas.getWidth());
    
  }

}
