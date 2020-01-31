package Player;

public class Player3 extends Player {

public final String price;
public String name;

Player3() {
    this.price = "300";
    this.name = "Player3";
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
