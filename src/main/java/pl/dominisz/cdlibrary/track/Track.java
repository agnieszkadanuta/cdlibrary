package pl.dominisz.cdlibrary.track;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.TimeUtils;

@Getter
@AllArgsConstructor
@ToString
public class Track {

    private String title;
    private int time;
    private String artist;
    private Genre genre;


    @Override
    public String toString() {
        return " Track: " +
                "title: " + title +
                ", time: " + TimeUtils.intTimeToString(time) +
                ", artist: " + artist +
                ", genre: " + genre.getDescription() +
                ".";
    }
}

