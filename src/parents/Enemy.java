package parents;

import java.util.ArrayList;
import java.util.Arrays;

import typedefs.Coordinates;

public abstract class Enemy extends Character {
  
  private String enemyName;
  private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
  private int[][] moveChances;

  public Enemy(String enemyName, Coordinates coord, Pokemon[] pokemon, int[][] moveChances, String s) {
    
    super(coord, s);
    
    setEnemyName(enemyName);
    setPokemons(new ArrayList<>(Arrays.asList(pokemon)));
    setMoveChances(moveChances);
    
  }

  public String getEnemyName() {
    return enemyName;
  }

  public void setEnemyName(String enemyName) {
    this.enemyName = enemyName;
  }

  public ArrayList<Pokemon> getPokemons() {
    return pokemons;
  }

  public void setPokemons(ArrayList<Pokemon> pokemons) {
    this.pokemons = pokemons;
  }

  public int[][] getMoveChances() {
    return moveChances;
  }

  public void setMoveChances(int[][] moveChances) {
    this.moveChances = moveChances;
  }

}
