package Player;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Player6 extends Player3 {

public final String price;
public String name;
public Button buttonShuffle;
public String shuffleString = "Shuffle";

Player6() {
    this.price = "600";
    this.name = "Player6";
    this.buttonShuffle = new Button(shuffleString);

    buttonShuffle.setOnAction(e -> {
        shufflePlaylist();
        }
    );
}



public void shufflePlaylist() {
    System.out.println("Shuffle playlist !");
}


@Override
public void additionalButtonsConfig(Stage primaryStage, AtomicReference<Stage> playerStage) {

   try {
       this.buttonPlayAllSongs.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/player_play_button.png"));
       shadowEffectAndstyleSetToButton(buttonPlayAllSongs);

       this.buttonShuffle.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/shuffle_button.png"));
       shadowEffectAndstyleSetToButton(buttonShuffle);
   }
   catch (Exception ex) {
          playerStage.get().close();
          ExceptionProcessing exeption = new ExceptionProcessing();
          exeption.exceptionWindowShow(primaryStage);
   }
}


@Override
public HBox musicImageHBoxConfig(HBox musicImageHBox, Label musicLabel) {                               //  (добавлена кнопка <shuffle>)
    musicImageHBox.getChildren().addAll(buttonShuffle, new Label("      \n"), musicLabel);
    return musicImageHBox;
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
