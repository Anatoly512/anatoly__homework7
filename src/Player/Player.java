package Player;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Player {

private Button buttonStartMenu;
private Button buttonPlay;
private Button buttonStop;

public String name;
public String playString = "Play";
public String stopString = "Stop";

Player() {
    this.buttonStartMenu = new Button(" Start Menu ");
    this.buttonPlay = new Button(playString);
    this.buttonStop = new Button(stopString);
    this.name = "Player";
}


public void show(Stage primaryStage) throws IOException {

    BorderPane group = new BorderPane();
    AtomicReference<Stage> playerStage = new AtomicReference<>(new Stage());

    DropShadow dropShadow1 = new DropShadow();
    dropShadow1.setRadius(5.0);
    dropShadow1.setOffsetX(3.0);
    dropShadow1.setOffsetY(3.0);
    dropShadow1.setColor(Color.color(0.2, 0.9, 0.7));
    buttonStartMenu.setStyle("-fx-font-size: 18;");
    buttonStartMenu.setEffect(dropShadow1);

    DropShadow dropShadow2 = new DropShadow();
    dropShadow2.setRadius(5.0);
    dropShadow2.setOffsetX(3.0);
    dropShadow2.setOffsetY(3.0);
    dropShadow2.setColor(Color.color(0.1, 0.6, 0.9));
    buttonPlay.setEffect(dropShadow2);
    buttonStop.setEffect(dropShadow2);

    String setStyleForControlButtons = "-fx-background-color: \n" +
            "        rgba(0,0,0,0.08),\n" +
            "        linear-gradient(#5a61af, #51536d),\n" +
            "        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
            "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
            "    -fx-background-radius: 5,5,4;\n" +
            "    -fx-padding: 3 30 3 30;\n" +
            "    -fx-text-fill: #242d35;\n" +
            "    -fx-font-size: 12px;";
    buttonPlay.setStyle(setStyleForControlButtons);
    buttonStop.setStyle(setStyleForControlButtons);

    try {
        this.buttonStartMenu.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/music.png"));
        this.buttonPlay.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/player_play_button.png"));
        this.buttonStop.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/player_stop_button.png"));
    }
    catch (Exception ex) {
        playerStage.get().close();
        ExceptionProcessing exeption = new ExceptionProcessing();
        exeption.exceptionWindowShow(primaryStage);
    }


    buttonStartMenu.setOnAction(e -> {
        PlayerMenu playerSceneMenu = new PlayerMenu();
        try {
            playerSceneMenu.playerWindowMenu(primaryStage);
        } catch (Exception ignored) {
        }
        playerStage.get().close();
        }
    );


    HBox hboxControlPanel = new HBox();
    hboxControlPanel.getChildren().addAll(new Label("                              \n"), buttonPlay, buttonStop);

//   group.getChildren().add(buttonStartMenu);

    group.setCenter(hboxControlPanel);
    group.setBottom(buttonStartMenu);


    playerStage.get().setTitle(getName());
    playerStage.get().setScene(new Scene(group, 500, 300));
    playerStage.get().centerOnScreen();
    playerStage.get().show();



}


private ImageView addImageToButton(Stage primaryStage, AtomicReference<Stage> playerStage, String stringPathToResourse) throws IOException {

    ImageView imageView = null;
    InputStream input = null;
    try {
        input = getClass().getResourceAsStream(stringPathToResourse);
        Image image = new Image(input);
        imageView = new ImageView(image);
    } catch (Exception ex) {
        playerStage.get().close();
        ExceptionProcessing exeption = new ExceptionProcessing("Файла изображения нет на месте!");
        exeption.exceptionWindowShow(primaryStage);
    }
    finally {
        assert input != null;
        input.close();
    }
    return imageView;
}



public abstract String getPrice();


public String getName() {
     return this.name;
  }

}
