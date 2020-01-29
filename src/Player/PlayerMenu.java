package Player;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerMenu {

PlayerMenu() {

}

    public void playerWindowMenu(Stage primaryStage) {

        System.out.println("Start !");

        GridPane root = new GridPane();





        primaryStage.setTitle(" Menu ");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}
