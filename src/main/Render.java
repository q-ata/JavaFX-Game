package main;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import typedefs.MapItem;

public class Render {
  
  private static GraphicsContext gc = Main.getGc();
  private static Background bg = Main.bg;
  private static Protagonist protag = Main.getProtagonist();
  private static Random randomizer = new Random();
  
  public static void drawTitleScreen() {
    
    Render.gc.fillRect(0, 0, 800, 500);
    
    Render.gc.drawImage(Main.title, 0, 0, Main.getCanvas().getWidth(), Main.getCanvas().getHeight());
    Render.gc.drawImage(Main.continueButton, 50, 210);
    Render.gc.drawImage(Main.exitButton, 50, 360);
    if (HandleTitle.getSelected() == 0) {
      for (int i = 0; i < Math.floor(Render.randomizer.nextDouble() * 4) + 1; i++) {
        Render.gc.fillRect(Math.floor(Render.randomizer.nextDouble() * 60) + 70, Math.floor(Render.randomizer.nextDouble() * 20) + 290, 300, 6);
      }
    }
    else if (HandleTitle.getSelected() == 1) {
      for (int i = 0; i < Math.floor(Render.randomizer.nextDouble() * 4) + 1; i++) {
        Render.gc.fillRect(Math.floor(Render.randomizer.nextDouble() * 30) + 53, Math.floor(Render.randomizer.nextDouble() * 20) + 440, 135, 6);
      }
    }
    
  }
  
  public static void draw() {
    
    if (Render.protag.state != 1) {
      return;
    }
    
    Render.gc.fillRect(0, 0, 800, 500);
    
    int sx = Render.protag.x - 391;
    int sy = Render.protag.y - 237;
    int sw = 800;
    int sh = 500;
    int dx = 0;
    int dy = 0;
    int dw = 800;
    int dh = 500;
    
    if (Render.protag.x - 391 < 0) {
      sx += 391 - Render.protag.x;
      dx = 391 - Render.protag.x;
    }
    else if (Render.protag.x + 391 + Render.protag.w > bg.w) {
      dw -= Render.protag.x + 391 + Render.protag.w - bg.w;
      sw = dw;
    }
    
    if (Render.protag.y - 237 < 0) {
      sy += 237 - Render.protag.y;
      dy = 237 - Render.protag.y;
    }
    else if (Render.protag.y + 237 + Render.protag.h > bg.h) {
      dh -= Render.protag.y + 237 + Render.protag.h - bg.h;
      sh = dh;
    }
    
    gc.drawImage(Render.bg.sprite, sx, sy, sw, sh, dx, dy, dw, dh);
    
    for (MapItem item : Main.getMapItems()) {
      
      Render.gc.drawImage(item.sprite, item.vx, item.vy);
      
    }
    
  }

}
