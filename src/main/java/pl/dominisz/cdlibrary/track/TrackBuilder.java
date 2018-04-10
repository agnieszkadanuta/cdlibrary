package pl.dominisz.cdlibrary.track;

import pl.dominisz.cdlibrary.Genre;

import java.util.HashSet;
import java.util.Set;

public class TrackBuilder {


    private String title;
    private int time;
    private String artist;
    private Set<Genre> genres;

    public TrackBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public TrackBuilder setTime(int time){
        this.time = time;
        return this;
    }

    public TrackBuilder setArtist(String artist){
        this.artist = artist;
        return this;
    }

    public TrackBuilder setGenres(Set<Genre> genres){
        this.genres = new HashSet<>();
        return this;
    }

    public Track buildTrack(){
        return new Track(title, time, artist, genres);
    }
}
