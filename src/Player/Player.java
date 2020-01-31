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

Player() {
    this.buttonStartMenu = new Button(" Start Menu ");
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

    InputStream input = null;
    try {
        input = getClass().getResourceAsStream("resourses/images/music.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        this.buttonStartMenu.setGraphic(imageView);
        input.close();
    } catch (Exception ex) {
        playerStage.get().close();
        ExceptionProcessing exeption = new ExceptionProcessing("Файла изображения нет на месте!");
        exeption.exceptionWindowShow(primaryStage);
    }
    finally {
        assert input != null;
        input.close();
    }




    buttonStartMenu.setOnAction(e -> {
        PlayerMenu playerSceneMenu = new PlayerMenu();
        playerSceneMenu.playerWindowMenu(primaryStage);
        playerStage.get().close();
        }
    );


//   group.getChildren().add(buttonStartMenu);

    group.setCenter(buttonStartMenu);

    playerStage.get().setTitle(" Player1 ");
    playerStage.get().setScene(new Scene(group, 500, 300));
    playerStage.get().centerOnScreen();
    playerStage.get().show();



}



public abstract String getPrice();


}
