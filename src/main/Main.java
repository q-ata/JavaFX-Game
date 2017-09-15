package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import characters.PikachuEnemy;
import data.CreatePokemon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
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
import typedefs.Stats;

public class Main extends Application {
  
  private static Canvas canvas;
  private static GraphicsContext gc;
  public static Image background;
  public static Image title;
  public static Image continueButton;
  public static Image exitButton;
  
  public static Background bg;
  public static String curRegion;
  
  private static ArrayList<Character> entities = new ArrayList<Character>();
  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private static Protagonist protagonist;
  private static ArrayList<Solid> solids = new ArrayList<Solid>();
  
  private static ArrayList<MapItem> mapItems = new ArrayList<MapItem>();
  
  private static Media soundTrack;
  private static MediaPlayer soundtrackPlayer;
  private static Media initiateFightSound;
  private static MediaPlayer initiateFightSoundPlayer;
  
  public static boolean grassCheck = false;
  
  public static int visibleX = 391;
  public static int visibleY = 237;
  
  public static long tick = 1;
  public static long lastFpsTime = 0;

  @Override
  public void start(Stage stage) {
    
    try {
      
      Main.canvas = new Canvas(800, 500);
      Main.gc = getCanvas().getGraphicsContext2D();
      Main.background = new Image(getClass().getResource("/misc/stadium_grass.png").toString());
      Main.title = new Image(getClass().getResource("/title/base_title.png").toString());
      Main.continueButton = new Image(getClass().getResource("/title/continue_button.png").toString());
      Main.exitButton = new Image(getClass().getResource("/title/exit_button.png").toString());
      
      BufferedReader saveReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/save.txt")));
      ArrayList<String> saveLines = new ArrayList<String>();
      
      try {
        String line = saveReader.readLine();
        while (line != null) {
          saveLines.add(line);
          line = saveReader.readLine();
        }
      }
      finally {
        saveReader.close();
      }
      
      saveLines.forEach((line) -> {
        
        String[] data = line.split(" ")[1].split("\\|");
        
        if (line.startsWith("AREA ")) {
          int x = Integer.parseInt(data[1]);
          int y = Integer.parseInt(data[2]);
          Coordinates c = new Coordinates(x, y);
          Main.protagonist = new Protagonist(c);
          Main.visibleX -= c.x;
          Main.visibleY -= c.y;
          Main.protagonist.vx = 391;
          Main.protagonist.vy = 237;
          Main.curRegion = data[0];
        }
        
        else if (line.startsWith("POKEMON ")) {
          int[] idata = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            idata[i] = Integer.parseInt(data[i]);
          }
          int pokemon = idata[0];
          Stats pStats = new Stats(new int[] {idata[1], idata[2], idata[3], idata[4], idata[5], idata[6]});
          int[] moveset = Arrays.copyOfRange(idata, 7, data.length);
          Protagonist.addPokemon(CreatePokemon.createPokemon(pokemon,  pStats, moveset));
        }
        
      });
      
      BufferedReader mapReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/map/" + curRegion + ".txt")));
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
          Main.mapItems.add(Main.protagonist);
          Main.entities.add(Main.protagonist);
        }
        
        else if (line.startsWith("ITEM ")) {
          int type = Integer.parseInt(data[0]);
          if (type == 1) {
            Tree tree = new Tree(coords);
            Main.mapItems.add(tree);
            Main.solids.add(tree);
          }
          else if (type == 2) {
            LargeHouse house = new LargeHouse(coords);
            Main.mapItems.add(house);
            Main.solids.add(house);
          }
          else if (type == 3) {
            SmallHouse house = new SmallHouse(coords);
            Main.mapItems.add(house);
            Main.solids.add(house);
          }
          else if (type == 4) {
            Grass grass = new Grass(coords);
            Main.mapItems.add(grass);
          }
        }
        
        else if (line.startsWith("ENEMY ")) {
          int type = Integer.parseInt(data[0]);
          if (type == 1) {
            PikachuEnemy pika = new PikachuEnemy(coords);
            Main.mapItems.add(pika);
            Main.enemies.add(pika);
            // Main.entities.add(pika);
          }
        }
        
      });
      
      stage.setTitle("Definitely Not Pokemon");
      
      Main.gc.setFill(Color.AQUA);
      
      Scene scene = new Scene(new Group(getCanvas()));
      scene.setOnKeyPressed((event) -> KeyboardInputHandler.keyPressed(event));
      scene.setOnKeyReleased((event) -> KeyboardInputHandler.keyReleased(event));
      
      stage.setScene(scene);
      stage.getIcons().add(new Image("file:resources/misc/pokeball.png"));
      
      Timeline gameLoop = new Timeline();
      gameLoop.setCycleCount(Timeline.INDEFINITE);
      
      KeyFrame keyframe = new KeyFrame(
          
        Duration.seconds(0.016),
        
        new EventHandler<ActionEvent>() {
          
          public void handle(ActionEvent event) {
            
            if (protagonist.state == 0) {
              // title screen
              Render.drawTitleScreen();
            }
            else if (protagonist.state == 1) {
              // free roam
              StateUpdate.update();
              Render.draw();
              
            }
            else if (protagonist.state == 2) {
              // dialogue
              
            }
            else if (protagonist.state == 3) {
              // battle
              
            }
            
            if (++tick > 60) {
              tick = 1;
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
      
      Platform.runLater(new MusicPlayer());
      
    }
    
    catch(Exception e) {
      e.printStackTrace();
    }
    
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

  public static ArrayList<Character> getEntities() {
    return entities;
  }

  public static void setEntities(ArrayList<Character> entities) {
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

  public static Media getSoundTrack() {
    return soundTrack;
  }

  public static void setSoundTrack(Media soundTrack) {
    Main.soundTrack = soundTrack;
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