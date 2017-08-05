package moves;

import java.util.Random;

import typedefs.Move;
import typedefs.Stats;

public class Thunderbolt extends Move {

  public Thunderbolt() {
    
    super("Thunderbolt", 1, new int[] {1}, new int[] {50});
    
  }
  
  public int getDamage(Stats charStats, Stats enemyStats) {
    
    double base = Math.sqrt(charStats.level) + Math.sqrt(charStats.atk);
    double defense = Math.pow(enemyStats.def, 0.47 + (enemyStats.def/3.6/100));
    double elemental = 1;
    Random rand = new Random();
    double variance = 0.95 + (1.05 - 0.95) * rand.nextDouble();
    
    return 10 + (int) Math.round((base - defense) * elemental * variance);
    
  }
  
  public int getHeal(Stats charStats, Stats enemyStats) {
    return 0;
  }
  
}
