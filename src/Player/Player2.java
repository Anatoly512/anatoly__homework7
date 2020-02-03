package Player;

import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Player2 extends Player {

public final String price;
public String name;

Player2() {
    this.price = "0, broken";
    this.name = "Player2";
}







@Override
  public void additionalButtonsConfig(Stage primaryStage, AtomicReference<Stage> playerStage) {
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
