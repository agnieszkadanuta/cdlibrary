package pl.dominisz.cdlibrary.cd;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.TimeUtils;
import pl.dominisz.cdlibrary.track.Track;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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

    @Override
    public String toString() {
        String result =  "CD: " +
                "title: " + title +
                ", artist: " + artist +
                ", releaseYear: " + releaseYear +
                ", producer: " + producer +
                ", total time: " + TimeUtils.intTimeToString(getTotalTime()) +
                ", genre: " + genre.getDescription() + "\n";
        if(original){
            result += "CD is original\n";
        }
        result += "discCount: " + discCount +
                "\nTracks:\n";

        for (int i = 0; i < tracks.size(); i++) {
            result += (i + 1) +tracks.get(i).toString() + "\n";

        }
        return result;
    }
}
