package parents;

import java.util.HashMap;

import typedefs.Coordinates;
import typedefs.Move;
import typedefs.Stats;

public abstract class Enemy extends Character {
  
  private String name;
  private int atk;
  private int def;
  private int sta;
  private int spd;
  private int health;
  private HashMap<Integer, Move> moves = new HashMap<Integer, Move>();

  public Enemy(String name, Coordinates coord, Stats stats, HashMap<Integer, Move> availableMoves) {
    super(coord);
    setName(name);
    setAtk(stats.atk);
    setDef(stats.def);
    setSta(stats.sta);
    setSpd(stats.spd);
    setHealth(stats.health);
    setMoves(availableMoves);
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

  public HashMap<Integer, Move> getMoves() {
    return moves;
  }

  public void setMoves(HashMap<Integer, Move> moves) {
    this.moves = moves;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
