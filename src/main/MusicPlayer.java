package main;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MusicPlayer implements Runnable {

  @Override
  public void run() {
    
    Main.setSoundTrack(new Media(getClass().getResource("/soundtracks/main_soundtrack.mp3").toExternalForm()));
    Main.setInitiateFightSound(new Media(getClass().getResource("/soundtracks/initiate_fight.mp3").toExternalForm()));
    Main.setSoundtrackPlayer(new MediaPlayer(Main.getSoundTrack()));
    Main.setInitiateFightSoundPlayer(new MediaPlayer(Main.getInitiateFightSound()));
    Main.getSoundtrackPlayer().setVolume(0.1);
    Main.getSoundtrackPlayer().setAutoPlay(true);
    Main.getSoundtrackPlayer().setOnEndOfMedia(() -> Main.getSoundtrackPlayer().seek(Duration.ZERO));
    
  }

}
