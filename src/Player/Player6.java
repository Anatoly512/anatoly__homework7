package Player;

public class Player6 extends Player {

public final String price;
public String name;

Player6() {
    this.price = "600";
    this.name = "Player6";
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
