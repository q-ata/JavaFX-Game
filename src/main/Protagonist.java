package main;

import java.util.ArrayList;

import javafx.scene.image.Image;
import moves.Ember;
import moves.HeatWave;
import moves.IronTail;
import moves.Thunderbolt;
import parents.Character;
import parents.Pokemon;
import pokemon.Pikachu;
import typedefs.Coordinates;
import typedefs.Move;
import typedefs.Stats;

public class Protagonist extends Character {
  
  public boolean up = false;
  public boolean down = false;
  public boolean right = false;
  public boolean left = false;
  
  public boolean frozen = false;
  
  public final int w = 27;
  public final int h = 40;
  
  public int xVel = 0;
  public int yVel = 0;
  
  private static int tick = 1;
  private static String dir = "down";
  public static String spriteLocation = "file:resources/protag/protag_0.png";
  
  private static ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
  
  private static Stats stats = new Stats(new int[] {20, 18, 20, 15, 60, 15});
 
  public Protagonist(Coordinates coord) {
    
    super(coord, spriteLocation);
    
    this.id = 0;
    Protagonist.pokemons.add(new Pikachu(stats, new Move[] {new Ember(), new IronTail(), new Thunderbolt(), new HeatWave()}));
    
  }
  
  public void moveDirections() {
    if ((!up && !down && !left && !right) || frozen) {
      this.sprite = new Image("file:resources/protag/protag_" + dir + "_0.png");
      xVel = yVel = 0;
      return;
    }
    
    if (Main.tick < 15 || (Main.tick >= 30 && Main.tick < 45)) {
      tick = 2;
    }
    else {
      tick = 1;
    }
    
    if (up) {
      yVel = -3;
      xVel = 0;
      this.sprite = new Image("file:resources/protag/protag_up_" + String.valueOf(tick) + ".png");
      dir = "up";
    }
    else if (down) {
      yVel = 3;
      xVel = 0;
      this.sprite = new Image("file:resources/protag/protag_down_" + String.valueOf(tick) + ".png");
      dir = "down";
    }
    
    else if (right) {
      xVel = 3;
      yVel = 0;
      this.sprite = new Image("file:resources/protag/protag_right_" + String.valueOf(tick) + ".png");
      dir = "right";
    }
    else if (left) {
      xVel = -3;
      yVel = 0;
      this.sprite = new Image("file:resources/protag/protag_left_" + String.valueOf(tick) + ".png");
      dir = "left";
    }
    
  }

  public Stats getStats() {
    return stats;
  }

  public static void setStats(Stats stats) {
    Protagonist.stats = stats;
  }

  public static ArrayList<Pokemon> getPokemons() {
    return pokemons;
  }

  public static void setPokemons(ArrayList<Pokemon> pokemons) {
    Protagonist.pokemons = pokemons;
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
