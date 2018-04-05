package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackBuilderTest {


    @Test
    void testTrackBuilderTest(){

        String title = "title";
        int time = 100;
        String artist = "artist";
        Genre genre = Genre.AMBIENT;

        Track track = new TrackBuilder().setArtist(artist).setTime(100).setTitle(title).setGenre(genre).buildTrack();

        assertEquals(artist, track.getArtist());
        assertEquals(time, track.getTime());
        assertEquals(title, track.getTitle());
        assertEquals(genre, track.getGenre());


    }

}
