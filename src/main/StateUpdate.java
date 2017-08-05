package main;

import java.util.ArrayList;

import typedefs.Solid;

public class StateUpdate {
  
  public static synchronized void update() {
    
    Protagonist protag = Main.getProtagonist();
    Solid[] solids = Main.getSolids();
    
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
      
      if (protag.up || protag.down || protag.right || protag.left) {
        Main.visibleX -= protag.xVel;
        Main.visibleY -= protag.yVel;
        solid.vx = Main.visibleX + solid.x;
        solid.vy = Main.visibleY + solid.y;
      }
      
    }
    
    protag.x += protag.xVel;
    protag.y += protag.yVel;
    
  }
  
}
