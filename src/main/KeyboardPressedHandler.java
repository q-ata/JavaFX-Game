package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardPressedHandler implements EventHandler<KeyEvent> {

  @Override
  public void handle(KeyEvent event) {
    
    KeyCode key = event.getCode();
    Protagonist protag = Main.getProtagonist();

    if (protag.state == 1) {
    
      if (key.equals(KeyCode.W) && !protag.up) {
        protag.up = true;
        protag.down = protag.right = protag.left = false;
        protag.setMovement("up");
      }
      
      else if (key.equals(KeyCode.S) && !protag.down) {
        protag.down = true;
        protag.up = protag.right = protag.left = false;
        protag.setMovement("down");
      }
      
      if (key.equals(KeyCode.D) && !protag.right) {
        protag.right = true;
        protag.down = protag.up = protag.left = false;
        protag.setMovement("right");
      }
      else if (key.equals(KeyCode.A) && !protag.left) {
        protag.left = true;
        protag.down = protag.right = protag.up = false;
        protag.setMovement("left");
      }
      
    }
    
    else if (protag.state == 0) {
      
      if (key.equals(KeyCode.DOWN)) {
        HandleTitle.incrementSelected(true);
      }
      
      else if (key.equals(KeyCode.UP)) {
        HandleTitle.incrementSelected(false);
      }
      
      else if (key.equals(KeyCode.ENTER)) {
        HandleTitle.select();
      }
      
    }
    
    else if (protag.state == 3) {
      
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

}
