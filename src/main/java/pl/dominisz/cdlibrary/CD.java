package pl.dominisz.cdlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
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

    public int getTotalTime() {
        if (tracks != null) {

      /*  int totalTime = 0;
        for (int i = 0; i < tracks.size(); i++) {
            totalTime += tracks.get(i).getTime();
        }
        return totalTime;*/

            //strumienie
            return tracks.stream().mapToInt(track -> track.getTime()).sum();

        } else {
            return 0;
        }
    }
}
