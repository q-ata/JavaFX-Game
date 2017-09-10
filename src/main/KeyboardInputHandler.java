package main;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardInputHandler {
  
  private static Protagonist protag = Main.getProtagonist();

  public static void keyPressed(KeyEvent event) {
    
    KeyCode key = event.getCode();

    if (protag.state == 0) {
    
      protag.setMovement(key);
      
    }
    
    else {
      
      if (key.equals(KeyCode.DOWN)) {
        Battle.changeSelectedMove(0);
      }
      
      else if (key.equals(KeyCode.UP)) {
        Battle.changeSelectedMove(1);
      }
      
      else if (key.equals(KeyCode.ENTER)) {
        Battle.executeMove();
      }
      
    }
    
  }

  public static void keyReleased(KeyEvent event) {
    
    KeyCode key = event.getCode();
    
    if (key.equals(KeyCode.W)) {
      protag.up = false;
    }
    else if (key.equals(KeyCode.S)) {
      protag.down = false;
    }
    
    if (key.equals(KeyCode.D)) {
      protag.right = false;
    }
    else if (key.equals(KeyCode.A)) {
      protag.left = false;
    }
    
  }

}
