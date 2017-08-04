package main;

public class StateUpdate {
  
  public static synchronized void update() {
    
    Protagonist protag = Main.getProtagonist();
    
    protag.moveDirections();
    
  }
  
}
