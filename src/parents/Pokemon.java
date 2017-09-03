package parents;

import java.util.ArrayList;

import typedefs.Stats;

public class Pokemon {
  
  private String name;
  private int atk;
  private int def;
  private int sta;
  private int spd;
  private int health;
  private int level;
  private int xp = 0;
  private ArrayList<Integer> moves = new ArrayList<Integer>();
  private int type;
  private Stats stats;
  private String battleSprite;
  
  public Pokemon(String name, Stats stats, int[] moves, int type, String battleSprite) {
    
    setName(name);
    setAtk(stats.atk);
    setDef(stats.def);
    setSta(stats.sta);
    setSpd(stats.spd);
    setHealth(stats.health);
    setLevel(stats.level);
    for (int mIndex : moves) {
      this.moves.add(mIndex);
    }
    setType(type);
    setStats(stats);
    setBattleSprite(battleSprite);
    
  }
  
  public Stats getStats() {
    return stats;
  }
  
  public void setStats(Stats stats) {
    this.stats = stats;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAtk() {
    return atk;
  }
  public void setAtk(int atk) {
    this.atk = atk;
  }
  public int getDef() {
    return def;
  }
  public void setDef(int def) {
    this.def = def;
  }
  public int getSta() {
    return sta;
  }
  public void setSta(int sta) {
    this.sta = sta;
  }
  public int getSpd() {
    return spd;
  }
  public void setSpd(int spd) {
    this.spd = spd;
  }
  public int getHealth() {
    return health;
  }
  public void setHealth(int health) {
    this.health = health;
  }
  public ArrayList<Integer> getMoves() {
    return moves;
  }
  public void setMoves(ArrayList<Integer> arrayList) {
    this.moves = arrayList;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getBattleSprite() {
    return battleSprite;
  }

  public void setBattleSprite(String battleSprite) {
    this.battleSprite = battleSprite;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

}
