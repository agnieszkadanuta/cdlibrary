package pl.dominisz.cdlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;

        while(!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    addNewCD();
                    break;
                case 2:
                    showAllCDs();
                    break;
                default:
                    exit = true;
            }
            }
            cdLibrary.saveToFile();
        }


    private void showAllCDs() {
    }

    private void addNewCD() {
        System.out.println("Enter CD info: ");
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Artist: ");
        String artist = scanner.nextLine();
        System.out.println("Release year: ");
        int releaseYear = scanner.nextInt();
        System.out.println("Producer: ");
        String producer = scanner.nextLine();
        Genre genre = readGenre();
        List<Track> tracks = readTracks();
        System.out.println("Is original(yes/no");
        boolean original = "yes".equals(scanner.nextLine());
        System.out.println("Disc count: ");
        int discCount = scanner.nextInt();
    }

    private List<Track> readTracks() {
        return new ArrayList<>();
    }

    private Genre readGenre() {
        return null;
    }


    public static void main(String[] args){

        App app = new App();
        app.showMainMenu();

    }
}
