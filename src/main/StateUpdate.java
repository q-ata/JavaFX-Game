package main;

import typedefs.Solid;

public class StateUpdate {
  
  public static synchronized void update() {
    
    Protagonist protag = Main.getProtagonist();
    Solid[] solids = Main.getSolids();
    
    protag.moveDirections();
    
    for (Solid solid : solids) {
      
      /*
      if (solid.hitbox.intersects(protag.hitbox.getHeight(), protag.hitbox.getWidth(), protag.hitbox.getX(), protag.hitbox.getY())) {
        System.out.println("collision");
          if (protag.up) {
            protag.y += 3;
          }
          else if (protag.down) {
            protag.y += -3;
          }
          if (protag.right) {
            protag.x += -3;
          }
          else if (protag.left) {
            protag.x -= 3;
          }
      }
      */
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
    
    protag.x += protag.xVel;
    protag.y += protag.yVel;
    
  }
  
}
