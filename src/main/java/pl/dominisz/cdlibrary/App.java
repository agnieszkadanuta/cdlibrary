package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.menu.CDDisplay;
import pl.dominisz.cdlibrary.menu.CDReader;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private static final String FILENAME = "cdlibrary.txt";

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);
    private CDReader cdReader = new CDReader(cdLibrary, scanner);
    private Finder finder = new Finder(cdLibrary, scanner);


    public void showMainMenu() {

        cdLibrary.loadFromFile(FILENAME);
        boolean exit = false;

        while(!exit) {
            System.out.println("Main menu");
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Find CDs by ARTIST");
            System.out.println("4. Find all artist");
            System.out.println("5. Find CD by TITLE");
            System.out.println("6. Find track by TITLE");
            System.out.println("7. Find CD by track TITLE:");
            System.out.println("8. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    cdReader.addNewCD();
                    break;
                case 2:
                    CDDisplay.show(cdLibrary.getCDs());
                    break;
                case 3:
                    finder.findByArtist();
                    break;
                case 4:
                    finder.findAllArtist();
                    break;
                case 5:
                    finder.findCDByTitle();
                    break;
                case 6:
                    finder.findTrackByTitle();
                    break;
                case 7:
                    finder.findCDsByTrackTitle();
                    break;
                default:
                    exit = true;
            }
            }
            cdLibrary.saveToFile(FILENAME);
        }


    private void showAllCDs() {

    }


    public static void main(String[] args){

        App app = new App();
        app.showMainMenu();

    }
}
