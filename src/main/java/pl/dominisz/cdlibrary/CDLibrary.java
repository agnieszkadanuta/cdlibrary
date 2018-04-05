package pl.dominisz.cdlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDLibrary {

    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd){
        CDs.add(cd);
    }

    public void saveToFile(){

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
