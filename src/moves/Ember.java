package moves;

import java.util.Random;

import typedefs.Move;
import typedefs.Stats;

public class Ember extends Move {

  public Ember() {
    
    super("Ember", 1, new int[] {1}, new int[] {50}, 2, 100);
    
  }
  
  public int getDamage(Stats charStats, Stats enemyStats) {
    
    double base = Math.sqrt(charStats.level) + Math.sqrt(charStats.atk);
    double defense = Math.pow(enemyStats.def, 0.47 + (enemyStats.def/3.6/100));
    double elemental = 1;
    Random rand = new Random();
    double variance = 0.8 + (1.2 - 0.8) * rand.nextDouble();
    int hit = rand.nextInt(100) + 1;
    
    if (hit > this.getAcc()) {
      this.setMiss(true);
      return 0;
    }
    
    return 10 + (int) Math.round((base - defense) * elemental * variance);
    
  }
  
  public int getHeal(Stats charStats, Stats enemyStats) {
    return 0;
  }
  
}
