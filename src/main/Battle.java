package main;

import java.util.Random;

import data.MoveMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import parents.Enemy;
import parents.Pokemon;
import typedefs.Move;

public class Battle {
  
  private static Move selectedMove;
  private static int selectedMoveIndex;
  
  private static Pokemon friendlyStarter;
  private static Pokemon enemyStarter;
  private static int enemyPokemonIndex = 0;
  
  public static boolean moveConfirmed = false;
  
  private static Enemy enemy;
  
  public Battle(Protagonist protag, Enemy enemy) {
    
    Battle.enemy = enemy;
    
    GraphicsContext gc = Main.getGc();
    
    protag.state = 1;
    
    gc.drawImage(Main.background, 0, 0, 800, 500);
    
    friendlyStarter = Protagonist.getPokemons().get(0);
    enemyStarter = enemy.getPokemons().get(0);
    String[] friendlyMoveNames = new String[friendlyStarter.getMoves().size()];
    String[] enemyMoveNames = new String[enemyStarter.getMoves().size()];
    for (int i = 0; i < friendlyStarter.getMoves().size(); i++) {
      friendlyMoveNames[i] = MoveMap.MOVEMAP.get(friendlyStarter.getMoves().get(i)).getName();
    }
    for (int i = 0; i < enemyStarter.getMoves().size(); i++) {
      enemyMoveNames[i] = MoveMap.MOVEMAP.get(enemyStarter.getMoves().get(i)).getName();
    }
    Text friendlyInfo = new Text("Level " + String.valueOf(friendlyStarter.getLevel()) + " " + friendlyStarter.getName() + "\n" + friendlyStarter.getHealth() + "HP " + friendlyStarter.getSta() + "STA\n" + String.join("\n", friendlyMoveNames));
    friendlyInfo.setFont(new Font(20));
    double friendlyHPWidth = friendlyInfo.getLayoutBounds().getWidth();
    Text enemyInfo = new Text("Level " + String.valueOf(enemyStarter.getLevel()) + " " + enemyStarter.getName() + "\n" + enemyStarter.getHealth() + "HP " + enemyStarter.getSta() + "STA\n" + String.join("\n", enemyMoveNames));
    enemyInfo.setFont(new Font(20));
    double enemyHPWidth = enemyInfo.getLayoutBounds().getWidth();
    
    Image friendlySprite = new Image(friendlyStarter.getBattleSprite());
    
    gc.drawImage(friendlySprite, 100 + friendlySprite.getWidth(), 100, -friendlySprite.getWidth(), friendlySprite.getHeight());
    gc.drawImage(new Image(enemyStarter.getBattleSprite()), 518, 100);
    gc.setFill(Color.BLACK);
    gc.setFont(new Font(20));
    gc.fillText(friendlyInfo.getText(), 191 - (friendlyHPWidth / 2), 345);
    gc.fillText(enemyInfo.getText(), 609 - (enemyHPWidth / 2), 345);
    
    selectedMove = MoveMap.MOVEMAP.get(friendlyStarter.getMoves().get(selectedMoveIndex));
    
  }
  
  public static void doBattle() {
    
    return;
    
  }
  
  public static void changeSelectedMove(int op) {
    
    if (op == 0 && selectedMoveIndex < friendlyStarter.getMoves().size() - 1) {
      selectedMove = MoveMap.MOVEMAP.get(friendlyStarter.getMoves().get(++selectedMoveIndex));
    }
    
    else if (op == 1 && selectedMoveIndex > 0) {
      selectedMove = MoveMap.MOVEMAP.get(friendlyStarter.getMoves().get(--selectedMoveIndex));
    }
    
    System.out.println("The selected move is now " + selectedMove.getName());
    
  }
  
  public static void executeMove() {
    
    int damageDealt = selectedMove.getDamage(friendlyStarter.getStats(), enemyStarter.getStats());
    
    enemyStarter.setHealth(enemyStarter.getHealth() - damageDealt);
    
    System.out.println(friendlyStarter.getName() + " used " + selectedMove.getName() + "!\nIt dealt " + String.valueOf(damageDealt) + " damage! " + enemyStarter.getName() + " now has " + enemyStarter.getHealth() + "HP remaining.\n");
    
    Move[] enemyMoveSet = new Move[100];
    int[] enemyMoveChances = enemy.getMoveChances()[enemyPokemonIndex];
    int counter = 0;
    
    for (int i = 0; i < enemyMoveChances.length; i++) {
      for (int x = 0; x < enemyMoveChances[i]; x++) {
        enemyMoveSet[counter] = MoveMap.MOVEMAP.get(enemyStarter.getMoves().get(i));
        counter++;
      }
    }
    
    Random moveChoiceGenerator = new Random();
    
    Move enemyMoveChoice = enemyMoveSet[(int) Math.floor(moveChoiceGenerator.nextDouble() * 100)];
    
    int enemyDamageDealt = enemyMoveChoice.getDamage(enemyStarter.getStats(), friendlyStarter.getStats());
    
    friendlyStarter.setHealth(friendlyStarter.getHealth() - enemyDamageDealt);
    
    System.out.println(enemyStarter.getName() + " used " + enemyMoveChoice.getName() + "!\nIt dealt " + String.valueOf(enemyDamageDealt) + " damage! " + friendlyStarter.getName() + " now has " + friendlyStarter.getHealth() + "HP remaining.\n");
    
  }

}
