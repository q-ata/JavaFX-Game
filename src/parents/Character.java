package parents;

import java.util.Timer;

import main.AdvanceCharacterAnimation;
import typedefs.CharacterSpriteMap;
import typedefs.Coordinates;
import typedefs.MapItem;

public abstract class Character extends MapItem {
  
  public String dir = "down";
  private CharacterSpriteMap spriteMap;
  public boolean active = false;
  private Timer animationTimer;
  
  public Character(Coordinates coords, String s, CharacterSpriteMap spriteMap) {
    
    super(coords, s);
    
    setSpriteMap(spriteMap);
    this.animationTimer = new Timer();
    this.animationTimer.scheduleAtFixedRate(new AdvanceCharacterAnimation(this), 0, 1000 / this.getSpriteMap().up.length);
    
  }

  public CharacterSpriteMap getSpriteMap() {
    return spriteMap;
  }

  public void setSpriteMap(CharacterSpriteMap spriteMap) {
    this.spriteMap = spriteMap;
  }

}
