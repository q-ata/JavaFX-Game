package moves;

import java.util.Random;

import typedefs.Move;
import typedefs.Stats;

public class Ember extends Move {
  
  private Stats stats;
  private Stats estats;

  public Ember(Stats charStats, Stats enemyStats) {
    
    super("Ember", 1, new int[] {1}, new int[] {50});
    
    this.stats = charStats;
    this.estats = enemyStats;
    
  }
  
  public int getDamage() {
    
    double base = Math.sqrt(stats.level) + Math.sqrt(stats.atk);
    double defense = Math.pow(estats.def, 0.47 + (estats.def/3.6/100));
    double elemental = 1;
    Random rand = new Random();
    double variance = 0.95 + (1.05 - 0.95) * rand.nextDouble();
    
    return 10 + (int) Math.round((base - defense) * elemental * variance);
    
  }
  
  public int getHeal() {
    return 0;
  }
  
}
