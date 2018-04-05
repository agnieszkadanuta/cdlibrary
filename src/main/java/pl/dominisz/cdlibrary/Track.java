package pl.dominisz.cdlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Track {

    private String title;
    private int time;
    private String artist;
    private Genre genre;

}
