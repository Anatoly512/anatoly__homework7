package Player;

import javafx.css.Style;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerMenu extends BorderPane {

private final String pricePlayer1;
// private final String pricePlayer2;
// private final String pricePlayer3;
// private final String pricePlayer4;
// private final String pricePlayer5;
// private final String pricePlayer6;

private Label pricePlayar1Label;
private Label pricePlayar2Label;
private Label pricePlayar3Label;
private Label pricePlayar4Label;
private Label pricePlayar5Label;
private Label pricePlayar6Label;

Player player1;
Player player2;
Player player3;
Player player4;
Player player5;
Player player6;

private Label priceLabel;
private Button buttonErrorMessage;
private Button buttonPlayer1;

PlayerMenu() {

    this.player1 = new Player1();
    this.pricePlayer1 = player1.getPrice();


    this.pricePlayar1Label = new Label (pricePlayer1);

    this.buttonPlayer1 = new Button("Player 1");
    this.buttonErrorMessage = new Button(" Error ");
    this.priceLabel = new Label ("Price :  ");
}


    public void playerWindowMenu(Stage primaryStage) {

        System.out.println("Player Menu!");

        BorderPane root = new BorderPane();

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setRadius(5.0);
        dropShadow1.setOffsetX(3.0);
        dropShadow1.setOffsetY(3.0);
        dropShadow1.setColor(Color.color(0.4, 0.5, 0.5));
        buttonPlayer1.setEffect(dropShadow1);
        buttonErrorMessage.setEffect(dropShadow1);

        String setStyleForPlayers = "-fx-background-color: \n" +
                "        rgba(0,0,0,0.08),\n" +
                "        linear-gradient(#5a61af, #51536d),\n" +
                "        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
                "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
                "    -fx-background-radius: 5,5,4;\n" +
                "    -fx-padding: 3 30 3 30;\n" +
                "    -fx-text-fill: #242d35;\n" +
                "    -fx-font-size: 14px;";

        buttonPlayer1.setStyle(setStyleForPlayers);
        buttonErrorMessage.setStyle(setStyleForPlayers);


        buttonPlayer1.setOnAction(e -> {
            Player1 player1 = new Player1();
            player1.show(primaryStage);  }
        );


        buttonErrorMessage.setOnAction(e -> {
           ExceptionProcessing exeption = new ExceptionProcessing();
           exeption.exceptionWindowShow(primaryStage);  }
        );


        GridPane centerPane = new GridPane();

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(priceLabel, pricePlayar1Label);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(buttonErrorMessage);


 //    centerPane.add( new Label(""), 1, 1);
       centerPane.add(hbox1, 2, 0);
       centerPane.add(buttonPlayer1, 4,2);
       centerPane.add(hbox2, 4,3);

 //     centerPane.add( , 2, 0);
 //     centerPane.add( , 3,0);
 //     centerPane.add( , 5, 0);


        root.setCenter(centerPane);

        primaryStage.setTitle(" Menu ");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

}
