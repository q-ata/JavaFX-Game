package main;

import java.util.TimerTask;

import parents.Character;

import typedefs.CharacterSpriteMap;

public class AdvanceAnimation extends TimerTask {
  
  private Character c;
  private CharacterSpriteMap csm;
  private int cur = 1;
  
  public AdvanceAnimation(Character ent) {
    
    this.c = ent;
    this.csm = this.c.getSpriteMap();
    
  }

  @Override
  public void run() {
    
    if (!this.c.active) {
      return;
    }
    
    if (this.c.dir == "up") {
      this.c.sprite = this.csm.up[cur];
    }
    else if (this.c.dir == "down") {
      this.c.sprite = this.csm.down[cur];
    }
    else if (this.c.dir == "right") {
      this.c.sprite = this.csm.right[cur];
    }
    else {
      this.c.sprite = this.csm.left[cur];
    }
    
    cur++;
    if (cur == this.csm.up.length) {
      cur = 0;
    }
    
  }

}
