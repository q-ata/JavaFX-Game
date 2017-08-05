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
  
  public Move(String name, int element, int[] effects, int[] effectChances) {
    setName(name);
    this.effects = effects;
    this.effectChances = effectChances;
    setElement(element);
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
  
}
