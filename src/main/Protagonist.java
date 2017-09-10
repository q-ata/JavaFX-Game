package main;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import parents.Character;
import parents.Pokemon;
import typedefs.CharacterSpriteMap;
import typedefs.Coordinates;

public class Protagonist extends Character {
  
  public boolean up = false;
  public boolean down = false;
  public boolean right = false;
  public boolean left = false;
  
  public int state = 0;
  
  public final int w = 27;
  public final int h = 40;
  
  public int xVel = 0;
  public int yVel = 0;
  private int speed = 3;
  
  private static ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
 
  public Protagonist(Coordinates coord) {
    
    super(coord, "/protag/protag_down_0.png", new CharacterSpriteMap(new String[] {"/protag/protag_DIR_1.png", "/protag/protag_DIR_0.png", "/protag/protag_DIR_2.png", "/protag/protag_DIR_0.png"}));
    
  }
  
  public void moveDirections() {
    if ((!up && !down && !left && !right) || this.state != 0) {
      this.sprite = new Image(getClass().getResource("/protag/protag_" + this.dir + "_0.png").toString());
      xVel = yVel = 0;
      this.active = false;
      return;
    }
    
    this.active = true;
    
    if (up) {
      yVel = -speed;
      xVel = 0;
      dir = "up";
    }
    else if (down) {
      yVel = speed;
      xVel = 0;
      dir = "down";
    }
    
    else if (right) {
      xVel = speed;
      yVel = 0;
      dir = "right";
    }
    else if (left) {
      xVel = -speed;
      yVel = 0;
      dir = "left";
    }
    
  }

  public static ArrayList<Pokemon> getPokemons() {
    return pokemons;
  }

  public static void setPokemons(ArrayList<Pokemon> pokemons) {
    Protagonist.pokemons = pokemons;
  }
  
  public static void addPokemon(Pokemon p) {
    Protagonist.pokemons.add(p);
  }

  @Override
  public void specialProperties() {
    
    return;
    
  }

}
