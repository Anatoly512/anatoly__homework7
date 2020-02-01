package Player;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Player {

private Button buttonStartMenu;
public String name;

Player() {
    this.buttonStartMenu = new Button(" Start Menu ");
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



    try {
        this.buttonStartMenu.setGraphic(addImageToButton(primaryStage, playerStage, "resourses/images/music.png"));
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



//   group.getChildren().add(buttonStartMenu);

    group.setCenter(buttonStartMenu);


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
