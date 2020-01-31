package Player;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerMenu extends BorderPane {

private Button button;

PlayerMenu() {
    this.button = new Button(" Error ");
}

    public void playerWindowMenu(Stage primaryStage) {

        System.out.println("Player !");

        BorderPane root = new BorderPane();


        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setRadius(5.0);
        dropShadow1.setOffsetX(3.0);
        dropShadow1.setOffsetY(3.0);
        dropShadow1.setColor(Color.color(0.4, 0.5, 0.5));
        button.setEffect(dropShadow1);

        button.setOnAction(e -> {
           ExceptionProcessing exeption = new ExceptionProcessing();
           exeption.exceptionWindowShow(primaryStage);  }
        );

        root.setBottom(button);



        primaryStage.setTitle(" Menu ");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}
