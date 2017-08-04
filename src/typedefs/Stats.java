package typedefs;

public class Stats {
  
  public int atk;
  public int def;
  public int sta;
  public int spd;
  public int health;
  public int level;

  public Stats(int[] stats) {
    this.atk = stats[0];
    this.def = stats[1];
    this.sta = stats[2];
    this.spd = stats[3];
    this.health = stats[4];
    this.level = stats[5];
  }
  
}
