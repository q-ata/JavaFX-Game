package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import parents.Character;
import parents.Enemy;
import typedefs.Coordinates;

public class Main extends Application {
  
  private static final Canvas canvas = new Canvas(500, 500);
  private static final GraphicsContext gc = getCanvas().getGraphicsContext2D();
  
  private static HashMap<Integer, Character> entities = new HashMap<Integer, Character>();
  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private static Protagonist protagonist = new Protagonist(new Coordinates(0, 0));
  
  private static Media soundTrack = new Media(new File("./resources/soundtracks/main_soundtrack.mp3").toURI().toString());
  private static MediaPlayer soundtrackPlayer = new MediaPlayer(soundTrack);
  
  public static long tick = 1;
  public static long lastFpsTime = 0;

  @Override
  public void start(Stage stage) {
    
    stage.setTitle("A box.");
    
    gc.setFill(Color.rgb(106, 202, 163));
    
    Scene scene = new Scene(new Group(getCanvas()));
    scene.setOnKeyPressed((event) -> KeyboardInputHandler.keyPressed(event));
    scene.setOnKeyReleased((event) -> KeyboardInputHandler.keyReleased(event));
    
    soundtrackPlayer.setVolume(0.1);
    soundtrackPlayer.setAutoPlay(true);
    soundtrackPlayer.setOnEndOfMedia(() -> soundtrackPlayer.seek(Duration.ZERO));
    
    stage.setScene(scene);
    
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
          
        }
        
      }
      
    );
    
    gameLoop.getKeyFrames().add(keyframe);
    gameLoop.play();
    
    stage.show();
    
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

  public static ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public static void setEnemies(ArrayList<Enemy> enemies) {
    Main.enemies = enemies;
  }
  
}