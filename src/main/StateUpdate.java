package main;

import javafx.scene.media.MediaPlayer;
import parents.Enemy;
import typedefs.MapItem;
import typedefs.Solid;

public class StateUpdate {
  
  public static synchronized void update() {
    
    Protagonist protag = Main.getProtagonist();
    
    if (protag.frozen) {
      return;
    }
    
    Solid[] solids = Main.getSolids();
    Enemy[] enemies = Main.getEnemies();
    
    protag.moveDirections();
    
    for (Solid solid : solids) {
      
      if (protag.up && solid.y + solid.h >= protag.y && solid.y < protag.y + protag.h && solid.x < protag.x + protag.w && solid.x + solid.w > protag.x) {
        
        int diff = (solid.y + solid.h) % protag.y;
        if (diff < 3) {
          protag.yVel = diff;
        }
        else {
          protag.yVel = 0;
        }
        
      }
      else if (protag.down && solid.y <= protag.y + protag.h && solid.y + solid.h > protag.y && solid.x < protag.x + protag.w && solid.x + solid.w > protag.x) {
        
        int diff = (protag.y + protag.h) % solid.y;
        if (diff < 3) {
          protag.yVel = -diff;
        }
        else {
          protag.yVel = 0;
        }
        
      }
      
      else if (protag.right && solid.x <= protag.x + protag.w && solid.x + solid.w > protag.x && solid.y < protag.y + protag.h && solid.y + solid.h > protag.y) {
        
        int diff = (protag.x + protag.w) % solid.x;
        if (diff < 3) {
          protag.xVel = -diff;
        }
        else {
          protag.xVel = 0;
        }
        
      }
      else if (protag.left && solid.x + solid.w >= protag.x && solid.x < protag.x + protag.w && solid.y < protag.y + protag.h && solid.y + solid.h > protag.y) {
        
        int diff = (solid.x + solid.w) % protag.x;
        if (diff < 3) {
          protag.xVel = diff;
        }
        else {
          protag.xVel = 0;
        }
        
      }
      
    }
    
    for (Enemy enemy : enemies) {
      if (protag.x < enemy.x + enemy.w && protag.x + protag.w > enemy.x && protag.y < enemy.y + enemy.h && protag.h + protag.y > enemy.y) {
        Main.getSoundtrackPlayer().pause();
        MediaPlayer initiateFightSoundPlayer = Main.getInitiateFightSoundPlayer();
        initiateFightSoundPlayer.setVolume(0.2);
        initiateFightSoundPlayer.setAutoPlay(true);
        new Battle(protag, enemy);
      }
    }
  
    Main.visibleX -= protag.xVel;
    Main.visibleY -= protag.yVel;
    
    for (MapItem item : Main.getMapItems()) {
      item.vx = Main.visibleX + item.x;
      item.vy = Main.visibleY + item.y;
    }
    
    protag.x += protag.xVel;
    protag.y += protag.yVel;
    
  }
  
}
