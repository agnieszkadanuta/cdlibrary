package pl.dominisz.cdlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CD {

    //    * tytuł
    //    * wykonawca
    //    * rok wydania
    //    * czas trwania
    //    * lista utworów
    //    * gatunek muzyczny


    private String title;
    private String artist;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private List<Track> tracks;
    private boolean original;
    private int discCount;

    public int getTotalTime(){
        return 0;
    }



}
