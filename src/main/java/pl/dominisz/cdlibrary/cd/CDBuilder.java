package pl.dominisz.cdlibrary.cd;

import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.track.Track;

import java.util.ArrayList;
import java.util.List;

public class CDBuilder {

    private String title;
    private String artist;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private List<Track> tracks = new ArrayList<>();
    private boolean original;
    private int discCount;

    public CDBuilder addTrack(Track track) {
        tracks.add(track);
        return this;
    }

    public CDBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public CDBuilder setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public CDBuilder setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public CDBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public CDBuilder setOriginal(boolean original) {
        this.original = original;
        return this;
    }

    public CDBuilder setDiscCount(int discCount) {
        this.discCount = discCount;
        return this;
    }

    public CDBuilder setTracks(List<Track> tracks) {
        if (tracks == null) {
            this.tracks = tracks;
        } else {
            tracks.addAll(tracks);
        }
            return this;
        }

        public CD build () {
            return new CD(title, artist, releaseYear, producer, genre, tracks, original, discCount);
        }
    }
