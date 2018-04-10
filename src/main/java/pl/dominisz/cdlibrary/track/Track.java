package pl.dominisz.cdlibrary.track;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.TimeUtils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Track {

    private String title;
    private int time;
    private String artist;
    private Set<Genre> genres;


    @Override
    public String toString() {
        return " Track: " +
                "title: " + title +
                ", time: " + TimeUtils.intTimeToString(time) +
                ", artist: " + artist +
                ", genres: " + getGenresDescription() +
                ".";
    }

    private String getGenresDescription() {
        return genres.stream().map(genre -> genre.getDescription()).collect(Collectors.joining(", "));
    }
}

