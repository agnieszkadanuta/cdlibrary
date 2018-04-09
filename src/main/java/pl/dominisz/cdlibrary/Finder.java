package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.menu.CDDisplay;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Finder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public Finder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findByArtist() {
        System.out.println("Enter artist: ");
        String artist = scanner.nextLine();

        List<CD> listByArtist = cdLibrary.findByArtist(artist);
        System.out.println("All CDs by: " + artist);
        CDDisplay.show(listByArtist);
    }

    public void findAllArtist() {
        Set<String> listOfArtist = cdLibrary.findAllArtist();
        System.out.println("All artists from CD Library");
        listOfArtist.forEach(artist -> System.out.println(artist));
    }


    public void findCDByTitle() {
        System.out.println("Enter CD title: ");
        String title = scanner.nextLine();

        List<CD> cds = cdLibrary.findByTitle(title);
        System.out.println("All CDs titled: " + title);
        CDDisplay.show(cds);

    }
}
