package Player;

public enum PlaylistEnum{
    SONG1 ("resourses/media/Delta Goodrem - Innocent eyes.mp3"),
    SONG2 ("resourses/media/Lara Fabian - I Am Who I Am.mp3"),
    SONG3 ("resourses/media/Royksopp - What else is there.mp3"),
    SONG4 ("resourses/media/Tina Cousins - Killing Time.mp3");

public String name;

PlaylistEnum(String name) {
   this.name = name;
}



public static String[] getPlaylist() {
    return new String[]{String.valueOf(SONG1), String.valueOf(SONG2), String.valueOf(SONG3), String.valueOf(SONG4)};
}


public static String getNameOfFirstSong() {
    return String.valueOf(SONG1);
}

public static String getNameOfTheLastSong() {
    return String.valueOf(SONG4);
}


@Override
public String toString() {     //  ! Важно для правильного выведения имен файлов
   return this.name;
}


}

