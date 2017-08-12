package moves;

import java.util.Random;

import typedefs.Move;
import typedefs.Stats;

public class Thunderbolt extends Move {

  public Thunderbolt() {
    
    super("Thunderbolt", 1, new int[] {}, new int[] {}, 5, 90);
    
  }
  
  public int getDamage(Stats charStats, Stats enemyStats) {
    
    double base = Math.sqrt(charStats.level) + Math.sqrt(charStats.atk);
    double defense = Math.pow(enemyStats.def, 0.49 + (enemyStats.def/4/100));
    double elemental = 3;
    Random rand = new Random();
    double variance = 0.95 + (1.05 - 0.95) * rand.nextDouble();
    int hit = rand.nextInt(100) + 1;
    
    if (hit > this.getAcc()) {
      this.setMiss(true);
      return 0;
    }
    
    return 20 + (int) Math.round((base - defense) * elemental * variance);
    
  }
  
  public int getHeal(Stats charStats, Stats enemyStats) {
    return 0;
  }
  
}
