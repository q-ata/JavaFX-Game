package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import backdrops.Background;
import characters.PikachuEnemy;
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
import parents.Character;
import parents.Enemy;
import solids.LargeHouse;
import solids.SmallHouse;
import solids.Tree;
import typedefs.Coordinates;
import typedefs.Grass;
import typedefs.MapItem;
import typedefs.Solid;

public class Main extends Application {
  
  private static final Canvas canvas = new Canvas(800, 500);
  private static final GraphicsContext gc = getCanvas().getGraphicsContext2D();
  public static final Image background = new Image("file:resources/misc/stadium_grass.png");
  
  public static Background bg;
  
  private static HashMap<Integer, Character> entities = new HashMap<Integer, Character>();
  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private static Protagonist protagonist;
  private static ArrayList<Solid> solids = new ArrayList<Solid>();
  
  private static ArrayList<MapItem> mapItems = new ArrayList<MapItem>();
  
  private static Media soundTrack = new Media(new File("./resources/soundtracks/main_soundtrack.mp3").toURI().toString());
  private static MediaPlayer soundtrackPlayer = new MediaPlayer(soundTrack);
  private static Media initiateFightSound = new Media(new File("./resources/soundtracks/initiate_fight.mp3").toURI().toString());
  private static MediaPlayer initiateFightSoundPlayer = new MediaPlayer(initiateFightSound);
  
  public static int visibleX = 391;
  public static int visibleY = 237;
  
  public static long tick = 1;
  public static long lastFpsTime = 0;

  @Override
  public void start(Stage stage) throws Exception {
    
    BufferedReader mapReader = new BufferedReader(new FileReader("./resources/map/region1.txt"));
    ArrayList<String> mapLines = new ArrayList<String>();
    try {
      String line = mapReader.readLine();
      while (line != null) {
        mapLines.add(line);
        line = mapReader.readLine();
      }
    }
    finally {
      mapReader.close();
    }
    
    
    mapLines.forEach((line) -> {
      
      if (line.startsWith("//")) {
        return;
      }
      
      String d = line.split(" ")[1];
      String[] data = d.split("\\|");
      Coordinates coords = new Coordinates(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
      
      if (line.startsWith("MAP ")) {
        bg = new Background(coords, data[0]);
      }
      
      if (line.startsWith("PROTAG ")) {
        Main.protagonist = new Protagonist(coords);
        Main.visibleX -= coords.x;
        Main.visibleY -= coords.y;
        Main.protagonist.vx = 391;
        Main.protagonist.vy = 237;
        mapItems.add(Main.protagonist);
      }
      
      else if (line.startsWith("ITEM ")) {
        int type = Integer.parseInt(data[0]);
        if (type == 1) {
          Tree tree = new Tree(coords);
          mapItems.add(tree);
          solids.add(tree);
        }
        else if (type == 2) {
          LargeHouse house = new LargeHouse(coords);
          mapItems.add(house);
          solids.add(house);
        }
        else if (type == 3) {
          SmallHouse house = new SmallHouse(coords);
          mapItems.add(house);
          solids.add(house);
        }
        else if (type == 4) {
          Grass grass = new Grass(coords);
          mapItems.add(grass);
        }
      }
      
    });
    
    stage.setTitle("Definitely Not Pokemon");
    
    gc.setFill(Color.BLACK);
    
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
          
          if (protagonist.frozen) {
            Battle.doBattle();
          }
          
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

  public static ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public static void setEnemies(ArrayList<Enemy> enemies) {
    Main.enemies = enemies;
  }

  public static ArrayList<Solid> getSolids() {
    return solids;
  }

  public static void setSolids(ArrayList<Solid> solids) {
    Main.solids = solids;
  }

  public static ArrayList<MapItem> getMapItems() {
    return mapItems;
  }

  public static void setMapItems(ArrayList<MapItem> mapItems) {
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