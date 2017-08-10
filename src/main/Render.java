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
    
    gc.fillRect(0, 0, 800, 500);
    
    int sx = protag.x - 391;
    int sy = protag.y - 237;
    int sw = 800;
    int sh = 500;
    int dx = 0;
    int dy = 0;
    int dw = 800;
    int dh = 500;
    
    if (protag.x - 391 < 0) {
      sx += 391 - protag.x;
      dx = 391 - protag.x;
    }
    else if (protag.x + 391 + protag.w > bg.w) {
      dw -= protag.x + 391 + protag.w - bg.w;
      sw = dw;
    }
    
    if (protag.y - 237 < 0) {
      sy += 237 - protag.y;
      dy = 237 - protag.y;
    }
    else if (protag.y + 237 + protag.h > bg.h) {
      dh -= protag.y + 237 + protag.h - bg.h;
      sh = dh;
    }
    
    gc.drawImage(bg.sprite, sx, sy, sw, sh, dx, dy, dw, dh);
    
    for (MapItem item : Main.getMapItems()) {
      
      gc.drawImage(item.sprite, item.vx, item.vy);
      
    }
    
    /*
    Parameters:
     img - the image to be drawn or null.
     sx - the source rectangle's X coordinate position.
     sy - the source rectangle's Y coordinate position.
     sw - the source rectangle's width.
     sh - the source rectangle's height.
     dx - the destination rectangle's X coordinate position.
     dy - the destination rectangle's Y coordinate position.
     dw - the destination rectangle's width.
     dh - the destination rectangle's height.
    */
    
    gc.drawImage(new Image(Protagonist.spriteLocation), 391, 237);
    
  }

}
