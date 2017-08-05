package main;

import java.io.File;
import java.util.HashMap;

import characters.Pikachu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import moves.Ember;
import parents.Character;
import parents.Enemy;
import solids.Wall;
import typedefs.Coordinates;
import typedefs.MapItem;
import typedefs.Move;
import typedefs.Solid;
import typedefs.Stats;

public class Main extends Application {
  
  private static final Canvas canvas = new Canvas(500, 500);
  private static final GraphicsContext gc = getCanvas().getGraphicsContext2D();
  
  private static HashMap<Integer, Character> entities = new HashMap<Integer, Character>();
  private static Enemy[] enemies = new Enemy[1];
  private static Protagonist protagonist = new Protagonist(new Coordinates(241, 237));
  private static Solid[] solids = new Solid[1];
  
  private static MapItem[] mapItems = new MapItem[2];
  
  private static Media soundTrack = new Media(new File("./resources/soundtracks/main_soundtrack.mp3").toURI().toString());
  private static MediaPlayer soundtrackPlayer = new MediaPlayer(soundTrack);
  private static Media initiateFightSound = new Media(new File("./resources/soundtracks/initiate_fight.mp3").toURI().toString());
  private static MediaPlayer initiateFightSoundPlayer = new MediaPlayer(initiateFightSound);
  
  public static int visibleX = 0;
  public static int visibleY = 0;
  
  public static long tick = 1;
  public static long lastFpsTime = 0;

  @Override
  public void start(Stage stage) {
    
    Wall wall = new Wall(new Coordinates(300, 300));
    solids[0] = wall;
    HashMap<Integer, Move> pikachuMoves = new HashMap<Integer, Move>();
    Stats pikachuStats = new Stats(new int[] {15, 15, 10, 10, 50, 10});
    pikachuMoves.put(100, new Ember(pikachuStats, protagonist.getStats()));
    Pikachu pikachu = new Pikachu(new Coordinates(120, 120), pikachuStats, pikachuMoves);
    enemies[0] = pikachu;
    
    mapItems[0] = wall;
    mapItems[1] = pikachu;
    
    stage.setTitle("Definitely Not Pokemon");
    
    gc.setFill(Color.rgb(106, 202, 163));
    
    Scene scene = new Scene(new Group(getCanvas()));
    scene.setOnKeyPressed((event) -> KeyboardInputHandler.keyPressed(event));
    scene.setOnKeyReleased((event) -> KeyboardInputHandler.keyReleased(event));
    
    getSoundtrackPlayer().setVolume(0.1);
    getSoundtrackPlayer().setAutoPlay(true);
    getSoundtrackPlayer().setOnEndOfMedia(() -> getSoundtrackPlayer().seek(Duration.ZERO));
    
    stage.setScene(scene);
    stage.getIcons().add(new Image("file:resources/misc/pokeball.png"));
    
    Timeline gameLoop = new Timeline();
    gameLoop.setCycleCount(Timeline.INDEFINITE);
    
    KeyFrame keyframe = new KeyFrame(
        
      Duration.seconds(0.017),
      
      new EventHandler<ActionEvent>() {
        
        public void handle(ActionEvent event) {
          
          if (++tick > 60) {
            tick = 1;
          }
          
          StateUpdate.update();
          Render.draw();
          
        }
        
      }
      
    );
    
    gameLoop.getKeyFrames().add(keyframe);
    gameLoop.play();
    
    stage.show();
    
    stage.focusedProperty().addListener(new ChangeListener<Boolean>() {

      @Override
      public void changed(ObservableValue<? extends Boolean> ov, Boolean t1, Boolean t2) {
        protagonist.up = protagonist.down = protagonist.right = protagonist.left = false;
      }
      
    });
    
  }
  
  public void stop() {
    System.exit(0);
  }
  
  public static void main(String[] args) {
    launch(args);
  }
  public static Canvas getCanvas() {
    return canvas;
  }
  public static GraphicsContext getGc() {
    return gc;
  }

  public static HashMap<Integer, Character> getEntities() {
    return entities;
  }

  public static void setEntities(HashMap<Integer, Character> entities) {
    Main.entities = entities;
  }

  public static Protagonist getProtagonist() {
    return protagonist;
  }

  public static void setProtagonist(Protagonist protagonist) {
    Main.protagonist = protagonist;
  }

  public static Enemy[] getEnemies() {
    return enemies;
  }

  public static void setEnemies(Enemy[] enemies) {
    Main.enemies = enemies;
  }

  public static Solid[] getSolids() {
    return solids;
  }

  public static void setSolids(Solid[] solids) {
    Main.solids = solids;
  }

  public static MapItem[] getMapItems() {
    return mapItems;
  }

  public static void setMapItems(MapItem[] mapItems) {
    Main.mapItems = mapItems;
  }

  public static MediaPlayer getSoundtrackPlayer() {
    return soundtrackPlayer;
  }

  public static void setSoundtrackPlayer(MediaPlayer soundtrackPlayer) {
    Main.soundtrackPlayer = soundtrackPlayer;
  }

  public static Media getInitiateFightSound() {
    return initiateFightSound;
  }

  public static void setInitiateFightSound(Media initiateFightSound) {
    Main.initiateFightSound = initiateFightSound;
  }

  public static MediaPlayer getInitiateFightSoundPlayer() {
    return initiateFightSoundPlayer;
  }

  public static void setInitiateFightSoundPlayer(MediaPlayer initiateFightSoundPlayer) {
    Main.initiateFightSoundPlayer = initiateFightSoundPlayer;
  }
  
}