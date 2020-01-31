package Player;

public class Player1 extends Player {

public final String price;
public String name;

Player1() {
    this.price = "100";
    this.name = "Player1";
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
