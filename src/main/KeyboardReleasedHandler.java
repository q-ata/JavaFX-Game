package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardReleasedHandler implements EventHandler<KeyEvent> {

  @Override
  public void handle(KeyEvent event) {
    
    KeyCode key = event.getCode();
    Protagonist protag = Main.getProtagonist();
    
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
    
    if (!protag.up && !protag.down && !protag.right && !protag.left) {
      protag.active = false;
      protag.stopMovement();
    }
    
  }

}
