package typedefs;

public abstract class Move {
  
  private String name;

  public int dmg;
  public int heal;
  public int[] effects;
  public double dmgMod;
  public double healMod;
  public int[] effectChances;
  private int element;
  private int stam;
  private int acc;
  private boolean miss = false;
  
  public Move(String name, int element, int[] effects, int[] effectChances, int s, int a) {
    setName(name);
    this.effects = effects;
    this.effectChances = effectChances;
    setElement(element);
    setStam(s);
    setAcc(a);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getElement() {
    return element;
  }

  public void setElement(int element) {
    this.element = element;
  }
  
  public abstract int getDamage(Stats charStats, Stats enemyStats);
  public abstract int getHeal(Stats charStats, Stats enemyStats);

  public int getStam() {
    return stam;
  }

  public void setStam(int stam) {
    this.stam = stam;
  }

  public int getAcc() {
    return acc;
  }

  public void setAcc(int acc) {
    this.acc = acc;
  }

  public boolean isMiss() {
    return miss;
  }

  public void setMiss(boolean miss) {
    this.miss = miss;
  }
  
}
