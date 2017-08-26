package main;

import java.util.ArrayList;
import java.util.Random;

import characters.PikachuEnemy;
import javafx.scene.media.MediaPlayer;
import parents.Enemy;
import typedefs.Coordinates;
import typedefs.Grass;
import typedefs.Solid;

public class StateUpdate {
  
  public static void update() {
    
    Protagonist protag = Main.getProtagonist();
    
    if (protag.state != 0) {
      return;
    }
    
    ArrayList<Solid> solids = Main.getSolids();
    ArrayList<Enemy> enemies = Main.getEnemies();
    
    protag.moveDirections();
    
    for (Solid solid : solids) {
      
      if (protag.up && solid.hity + solid.h >= protag.y && solid.hity < protag.y + protag.h && solid.hitx < protag.x + protag.w && solid.hitx + solid.w > protag.x) {
        int diff = (solid.hity + solid.h) % protag.y;
        if (diff < 3) {
          protag.yVel = diff;
        }
        else {
          protag.yVel = 0;
        }
      }
      
      else if (protag.down && solid.hity <= protag.y + protag.h && solid.hity + solid.h > protag.y && solid.hitx < protag.x + protag.w && solid.hitx + solid.w > protag.x) {
        int diff = (protag.y + protag.h) % solid.hity;
        if (diff < 3) {
          protag.yVel = -diff;
        }
        else {
          protag.yVel = 0;
        }
      }
      
      else if (protag.right && solid.hitx <= protag.x + protag.w && solid.hitx + solid.w > protag.x && solid.hity < protag.y + protag.h && solid.hity + solid.h > protag.y) {
        int diff = (protag.x + protag.w) % solid.hitx;
        if (diff < 3) {
          protag.xVel = -diff;
        }
        else {
          protag.xVel = 0;
        }
      }
      
      else if (protag.left && solid.hitx + solid.w >= protag.x && solid.hitx < protag.x + protag.w && solid.hity < protag.y + protag.h && solid.hity + solid.h > protag.y) {
        int diff = (solid.hitx + solid.w) % protag.x;
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
    
    Main.getMapItems().forEach((item) -> {
      item.vx = Main.visibleX + item.x;
      item.vy = Main.visibleY + item.y;
      item.specialProperties();
      
      if (item instanceof Grass) {
        
        if (Main.tick != 60 || Main.grassCheck || (!protag.down && !protag.up && !protag.right && !protag.left) || (item.x > protag.x + protag.w || item.x + item.w < protag.x || item.y > protag.y + protag.h || item.h + item.y < protag.y)) {
          return;
        }
        
        Main.grassCheck = true;
        
        Random rand = new Random();
        
        if (rand.nextDouble() < 0.9) {
          return;
        }
        
        Main.getSoundtrackPlayer().pause();
        MediaPlayer initiateFightSoundPlayer = Main.getInitiateFightSoundPlayer();
        initiateFightSoundPlayer.setVolume(0.2);
        initiateFightSoundPlayer.setAutoPlay(true);
        new Battle(protag, new PikachuEnemy(new Coordinates(protag.x, protag.y)));
      }
    });
    
    protag.x += protag.xVel;
    protag.y += protag.yVel;
    
    Main.grassCheck = false;
    
  }
  
}
