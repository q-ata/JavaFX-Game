package data;

import java.util.HashMap;

import typedefs.Effectiveness;

public class TypeMap {
  
  public static final HashMap<Integer, Effectiveness> MOVEMAP = createTypeMap();
  
  private static HashMap<Integer, Effectiveness> createTypeMap() {
    
    HashMap<Integer, Effectiveness> map = new HashMap<Integer, Effectiveness>();
    
    map.put(1, new Effectiveness(new int[] {2}, new int[] {3}));
    map.put(2, new Effectiveness(new int[] {3, 4}, new int[] {1}));
    map.put(3, new Effectiveness(new int[] {1}, new int[] {2, 5}));
    map.put(4, new Effectiveness(new int[] {5}, new int[2]));
    map.put(5, new Effectiveness(new int[] {3}, new int[4]));
    
    return map;
    
  }

}
