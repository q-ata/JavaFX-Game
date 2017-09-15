package main;

import javafx.scene.paint.Color;

public class HandleTitle {
  
  private static int selected = 0;
  
  public static void incrementSelected(boolean option) {
    
    if (option && selected != 1) {
      selected++;
    }
    else if (!option && selected != 0) {
      selected--;
    }
    
  }
  
  public static void select() {
    
    if (HandleTitle.selected == 0) {
      Main.getGc().setFill(Color.BLACK);
      Main.getProtagonist().state = 1;
    }
    else if (HandleTitle.selected == 1) {
      System.exit(0);
    }
    
  }
  
  public static int getSelected() {
    return HandleTitle.selected;
  }

}
