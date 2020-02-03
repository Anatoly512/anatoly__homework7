package Player;

public class Player5 extends Player3 {

public final String price;
public String name;

Player5() {
    this.price = "500";
    this.name = "Player5";
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
