package Player;

import java.util.Arrays;

public class Player5 extends Player3 {

public final String price;
public String name;

String[] playlist = new String[PlaylistEnum.values().length];

Player5() {
    this.price = "500";
    this.name = "Player5";

    int lengthOfPlaylist = PlaylistEnum.values().length;

    for (PlaylistEnum name : PlaylistEnum.values()) {        //  В этом плеере песни играют в обратном порядке, с конца плейлиста в начало
        lengthOfPlaylist--;
        playlist[name.ordinal()] = PlaylistEnum.getPlaylist()[lengthOfPlaylist];
    }
}



@Override
    public void playAllSongs() {
        System.out.print("\nPlay all songs : ");

        String[] playlistShortNames = new String[(playlist.length)];

        for (int i = 0; i < playlist.length; i++) {
            String[] playSongSplitArray = playlist[i].split("/");
            playlistShortNames[i] = playSongSplitArray[(playSongSplitArray.length) - 1];
        }

        System.out.println(Arrays.toString(playlistShortNames) + "\n");


       for (int i = 0; i < PlaylistEnum.values().length; i++) {                                 //  Вывод всех песен на динамики
               realPlaySong(primaryStage, playerStage, playlist[i], playlistShortNames[i]);
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
