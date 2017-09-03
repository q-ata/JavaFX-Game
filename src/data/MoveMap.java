package data;

import java.util.HashMap;

import moves.Ember;
import moves.HeatWave;
import moves.IronTail;
import moves.Thunderbolt;
import typedefs.Move;

public class MoveMap {
  
  public static final HashMap<Integer, Move> MOVEMAP = createMoveMap();
  
  private static HashMap<Integer, Move> createMoveMap() {
    
    HashMap<Integer, Move> map = new HashMap<Integer, Move>();
    
    map.put(1, new Ember());
    map.put(2, new HeatWave());
    map.put(3, new IronTail());
    map.put(4, new Thunderbolt());
    
    return map;
    
  }

}
