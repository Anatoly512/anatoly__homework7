package Player;

import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Player4 extends Player3 {

public final String price;
public String name;

Player4() {
    this.price = "400";
    this.name = "Player4";
}


@Override
  public void playSong(Stage primaryStage, AtomicReference<Stage> playerStage) {
     System.out.println("Play last song ");

     String playSong = PlaylistEnum.getNameOfTheLastSong();

     System.out.println("Last song  :  " + playSong);

     realPlaySong(primaryStage, playerStage, playSong);

  }



@Override
  public String getPrice() {
      return this.price;
  }

@Override
  public String getName() {
      return this.name;
  }

}
