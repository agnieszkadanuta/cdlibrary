package pl.dominisz.cdlibrary;

import lombok.EqualsAndHashCode;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class CDLibrary {

    private static final String FILENAME = "cdlibrary.txt";
    private List<CD> CDs = new ArrayList<>();
    private List<Track> tracks = new ArrayList<>();

    public void add(CD cd) {
        CDs.add(cd);
    }

    public void saveToFile(String filename) {

        try {
            PrintWriter out = new PrintWriter(filename);
            out.println(CDs.size());
            for (CD cd : CDs) {
                saveCDToFile(out, cd);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save file" + filename);
        }
    }

    private void saveCDToFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getArtist());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getDiscCount());
        out.println(cd.isOriginal());
        out.println(cd.getTracks().size());

        for (Track track : cd.getTracks()) {
            saveTrackToFile(out, track);
        }
    }

    private void saveTrackToFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getArtist());
        out.println(track.getTime());
        out.println(track.getGenre());
    }

    public void loadFromFile(String filename) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                loadCDFromFile(bufferedReader);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Cannot load the file " + filename);
        }

    }

    private void loadCDFromFile(BufferedReader bufferedReader) throws IOException {

        CD cd = new CDBuilder().setTitle(bufferedReader.readLine()).setArtist(bufferedReader.readLine())
                .setReleaseYear(Integer.parseInt(bufferedReader.readLine()))
                .setProducer(bufferedReader.readLine()).setDiscCount(Integer.parseInt(bufferedReader.readLine()))
                .setOriginal(Boolean.valueOf(bufferedReader.readLine())).setTracks(loadTracksFromFile(bufferedReader))
                .build();
        CDs.add(cd);

    }

    private List<Track> loadTracksFromFile(BufferedReader bufferedReader) throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine());
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Track track = loadTrackFromFile(bufferedReader);
            tracks.add(track);
        }
        return tracks;
    }

    private Track loadTrackFromFile(BufferedReader bufferedReader) throws IOException {

        return new TrackBuilder().setTitle(bufferedReader.readLine()).setArtist(bufferedReader.readLine())
                .setTime(Integer.parseInt(bufferedReader.readLine())).setGenre(Genre.valueOf(bufferedReader.readLine()))
                .buildTrack();
    }


    public List<CD> getCDs() {
        return CDs;
    }

    public List<CD> findByArtist(String artist) {
        String lowerCaseArtist = artist.toLowerCase();
        return CDs.stream().filter(cd -> cd.getArtist().toLowerCase()
                .contains(lowerCaseArtist)).collect(Collectors.toList());
    }

    public Set<String> findAllArtist() {
        return CDs.stream().map(cd -> cd.getArtist()).collect(Collectors.toSet());
    }

    //znajduje płyty o tytule zawierającym dany tekst
    public List<CD> findByTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();
        return CDs.stream().filter(cd -> cd.getTitle().contains(lowerCaseTitle)).collect(Collectors.toList());

    }

    public List<Track> findTrackByTitle(String title) {
        String titletolowercase = title.toLowerCase();
        return CDs.stream().flatMap(cd -> cd.getTracks().stream().filter(track -> track.getTitle()
                .contains(titletolowercase))).collect(Collectors.toList());
    }

    public List<CD> findCDByTrackTitle(String title) {
        String titletolowercase = title.toLowerCase();
        return CDs.stream().filter(cd->cd.getTracks().stream()
                .anyMatch(track -> track.getTitle().contains(titletolowercase))).collect(Collectors.toList());
    }

    public List<CD> findByGenre(Genre genre) {
        return CDs.stream().filter(cd -> cd.getGenres().contains(genre)).collect(Collectors.toList());
    }


}
