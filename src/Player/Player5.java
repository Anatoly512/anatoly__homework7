package Player;

import java.util.Arrays;

public class Player5 extends Player3 {

public final String price;
public String name;

Player5() {
    this.price = "500";
    this.name = "Player5";
}



@Override
    public void playAllSongs() {                    //  В этом плеере песни играют в обратном порядке, с конца плейлиста в начало
        System.out.print("Play all songs : ");

        int lengthOfPlaylist = PlaylistEnum.values().length;

        String[] playlist = new String[lengthOfPlaylist];

        for (PlaylistEnum name : PlaylistEnum.values()) {
            lengthOfPlaylist--;
            playlist[name.ordinal()] = PlaylistEnum.getPlaylist()[lengthOfPlaylist];
        }

        System.out.println(Arrays.toString(playlist));

       for (int i = 0; i < PlaylistEnum.values().length; i++) {      //  Экспериментальный вариант  (что будет при остановке песни?  цикл продолжится?)
            realPlaySong(primaryStage, playerStage, playlist[i]);
       }

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
