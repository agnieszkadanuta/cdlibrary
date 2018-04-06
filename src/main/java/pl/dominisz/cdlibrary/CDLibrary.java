package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.track.Track;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CDLibrary {

    private static final String FILENAME = "cdlibrary.txt" ;
    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd){
        CDs.add(cd);
    }

    public void saveToFile(){

        try {
            PrintWriter out = new PrintWriter(FILENAME);
            out.println(CDs.size());
            for (CD cd:CDs) {
                saveCDToFile(out, cd);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save file" + FILENAME);
        }
    }

    private void saveCDToFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getArtist());
        out.println(cd.getTotalTime());
        out.println(cd.getGenre());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getDiscCount());
        out.println(cd.isOriginal());
        out.println(cd.getTracks().size());

        for(Track track : cd.getTracks()){
            saveTrackToFile(out, track);
        }
    }

    private void saveTrackToFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getArtist());
        out.println(track.getTime());
        out.println(track.getGenre());
    }

    public void loadFromFile(){

    }

    public List<CD> getCDs() {
        return CDs;
    }

    public List<CD> findByArtist(String artist){
        return new ArrayList<>();
    }

    //znajduje płyty o tytule zawierającym dany tekst
    public List<CD> findByTitle(String title){
        return new ArrayList<>();
    }

    public List<Track> findTrackByTitle(String title){
        return new ArrayList<>();
    }

    public List<CD> findCDByTrackTitle(String title){
        return new ArrayList<>();
    }

    public List<CD> findByGenre(Genre genre){
        return new ArrayList<>();
    }


}
