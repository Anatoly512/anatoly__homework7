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
        System.out.print("\nPlay all songs : ");

        int lengthOfPlaylist = PlaylistEnum.values().length;

        String[] playlist = new String[lengthOfPlaylist];

        for (PlaylistEnum name : PlaylistEnum.values()) {
            lengthOfPlaylist--;
            playlist[name.ordinal()] = PlaylistEnum.getPlaylist()[lengthOfPlaylist];
        }

        System.out.println(Arrays.toString(playlist) + "\n");


        String[] playlistShortNames = new String[(playlist.length)];

        for (int i = 0; i < playlist.length; i++) {
            String[] playSongSplitArray = playlist[i].split("/");
            playlistShortNames[i] = playSongSplitArray[(playSongSplitArray.length) - 1];
        }

        System.out.println(Arrays.toString(playlistShortNames) + "\n");


       for (int i = 0; i < PlaylistEnum.values().length; i++) {      //  Экспериментальный вариант.  (Как подождать (притормозить цикл), пока песня доиграет?)
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
