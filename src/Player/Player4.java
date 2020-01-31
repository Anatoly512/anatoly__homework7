package Player;

public class Player4 extends Player {

public final String price;
public String name;

Player4() {
    this.price = "400";
    this.name = "Player4";
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
