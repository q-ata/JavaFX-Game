package main;

import java.util.ArrayList;

import javafx.scene.media.MediaPlayer;
import parents.Enemy;
import typedefs.MapItem;
import typedefs.Solid;

public class StateUpdate {
  
  public static void update() {
    
    Protagonist protag = Main.getProtagonist();
    
    if (protag.frozen) {
      return;
    }
    
    ArrayList<Solid> solids = Main.getSolids();
    ArrayList<Enemy> enemies = Main.getEnemies();
    
    protag.moveDirections();
    
    for (Solid solid : solids) {
      
      if (protag.up && solid.y + solid.h >= protag.y && solid.y < protag.y + protag.h && solid.x < protag.x + protag.w && solid.x + solid.w > protag.x) {
        
        int diff;
        
        int sum = protag.y < 0 ? Math.abs(protag.y) : solid.y + solid.h;
        int divisor = protag.y < 0 ? Math.abs(solid.y + solid.h) : protag.y;
        
        if (sum == 0) {
          diff = Math.abs(protag.y / 3);
        }
        else {
          diff = divisor == 0 ? sum % 3 : sum % divisor;
        }
        
        if (diff < 3) {
          protag.yVel = diff;
        }
        else {
          protag.yVel = 0;
        }
        
      }
      else if (protag.down && solid.y < protag.y + protag.h + 3 && solid.y + solid.h > protag.y && solid.x < protag.x + protag.w && solid.x + solid.w > protag.x) {
        
        int diff;
        
        int sum = protag.y < 0 ? Math.abs(solid.y) : protag.y + protag.h;
        int divisor = protag.y < 0 ? Math.abs(protag.y + protag.h) : protag.y;
        
        if (sum == 0) {
          diff = Math.abs(protag.y / 3);
        }
        else {
          diff = divisor == 0 ? sum % 3 : sum % divisor;
        }
        
        if (diff < 3) {
          protag.yVel = -diff;
        }
        else {
          protag.yVel = 0;
        }
        
      }
      
      else if (protag.right && solid.x < protag.x + protag.w + 3 && solid.x + solid.w > protag.x && solid.y < protag.y + protag.h && solid.y + solid.h > protag.y) {
        
        int diff;
        
        int sum = protag.x < 0 ? Math.abs(solid.x) : protag.x + protag.w;
        int divisor = protag.x < 0 ? Math.abs(protag.x + protag.w) : solid.x;
        
        if (sum == 0) {
          diff = Math.abs(protag.x / 3);
        }
        else {
          diff = divisor == 0 ? sum % 3 : sum % divisor;
        }
        
        if (diff < 3) {
          protag.xVel = -diff;
        }
        else {
          protag.xVel = 0;
        }
        
      }
      else if (protag.left && solid.x + solid.w + 3 > protag.x && solid.x < protag.x + protag.w && solid.y < protag.y + protag.h && solid.y + solid.h > protag.y) {
        
        int diff;
        
        int sum = protag.x < 0 ? Math.abs(solid.x) : protag.x + protag.w;
        int divisor = protag.x < 0 ? Math.abs(solid.x + solid.w) : protag.x;
        
        if (sum == 0) {
          diff = Math.abs(protag.x / 3);
        }
        else {
          diff = divisor == 0 ? sum % 3 : sum % divisor;
        }
        
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
