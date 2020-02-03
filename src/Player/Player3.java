package Player;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Player3 extends Player {

public final String price;
public String name;
public Button buttonPlayAllSongs;
public String playAllSongsString = "Play all songs";

Player3() {
    this.price = "300";
    this.name = "Player3";
    this.buttonPlayAllSongs = new Button(playAllSongsString);

    buttonPlayAllSongs.setOnAction(e -> {
                playAllSongs();
            }
    );
}






public void playAllSongs() {
    System.out.println("Play all songs ");
}



public void additionalButtonsConfig(Stage primaryStage, AtomicReference<Stage> playerStage) {

    try {
        this.buttonPlayAllSongs.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/player_play_button.png"));
        shadowEffectAndstyleSetToButton(buttonPlayAllSongs);
        }
    catch (Exception ex) {
        playerStage.get().close();
        ExceptionProcessing exeption = new ExceptionProcessing();
        exeption.exceptionWindowShow(primaryStage);
    }

}



public HBox configPane(HBox hboxControlPanel) {
    hboxControlPanel.getChildren().addAll(buttonPlayAllSongs);
    return hboxControlPanel;
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
