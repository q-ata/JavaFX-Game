package main;

import parents.Character;
import typedefs.Coordinates;

public class Protagonist extends Character {
 
  public Protagonist(Coordinates coord) {
    super(coord);
    this.id = 0;
    this.vx = 241;
    this.vy = 237;
  }

  public boolean up = false;
  public boolean down = false;
  public boolean right = false;
  public boolean left = false;
  
  public final int w = 18;
  public final int h = 26;
  
  public int xVel = 0;
  public int yVel = 0;
  
  private static int tick = 1;
  private static String dir = "down";
  public static String spriteLocation = "file:resources/protag/protag_0.png";
  
  public void moveDirections() {
    if (!up && !down && !left && !right) {
      spriteLocation = "file:resources/protag/protag_" + dir + "_0.png";
      xVel = yVel = 0;
      return;
    }
    
    if (Main.tick < 15 || (Main.tick >= 30 && Main.tick < 45)) {
      tick = 2;
    }
    else {
      tick = 1;
    }
    
    if (up) {
      yVel = -3;
      xVel = 0;
      spriteLocation = "file:resources/protag/protag_up_" + String.valueOf(tick) + ".png";
      dir = "up";
    }
    else if (down) {
      yVel = 3;
      xVel = 0;
      spriteLocation = "file:resources/protag/protag_down_" + String.valueOf(tick) + ".png";
      dir = "down";
    }
    
    else if (right) {
      xVel = 3;
      yVel = 0;
      spriteLocation = "file:resources/protag/protag_right_" + String.valueOf(tick) + ".png";
      dir = "right";
    }
    else if (left) {
      xVel = -3;
      yVel = 0;
      spriteLocation = "file:resources/protag/protag_left_" + String.valueOf(tick) + ".png";
      dir = "left";
    }
    
  }

}
