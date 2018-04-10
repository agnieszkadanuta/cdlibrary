package pl.dominisz.cdlibrary;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CDLibraryTest {

    CDLibrary cdLibrary;

    private static final String TRACK_1 = "aaa;AAA;100;BLUES";
    private static final String TRACK_2 = "bbb;AAA;200;BLUES";
    private static final String TRACK_3 = "ccc;BBB;300;AMBIENT";
    private static final String TRACK_4 = "aab;BBB;300;AMBIENT";
    private static final String TRACK_5 = "ccd;AAA;400;ROCK";
    private static final String TRACK_6 = "bbw;CCC;200;FOLK";

    private static final String STRINGCD_1 ="title1;AAA;1999;JAK;AMBIENT;true;2";
    private static final String STRINGCD_2 ="title2;BBB;1998;JAKI;FOLK;true;1";
    private static final String STRINGCD_3 ="title3;CCC;1997;JAKO;BLUES;false;1";
    private static final String STRINGCD_4 ="title3;AAA;1999;JAK;AMBIENT;true;2";


    @BeforeEach
    void setup() {
        cdLibrary = new CDLibrary();
        CD cd1= createCD(STRINGCD_1);
        cd1.getTracks().add(createTrack(TRACK_1));
        cd1.getTracks().add(createTrack(TRACK_2));
        CD cd2 = createCD(STRINGCD_2);
        cd2.getTracks().add(createTrack(TRACK_3));
        cd2.getTracks().add(createTrack(TRACK_4));
        CD cd3 = createCD(STRINGCD_3);
        cd3.getTracks().add(createTrack(TRACK_5));
        CD cd4 = createCD(STRINGCD_4);
        cd4.getTracks().add(createTrack(TRACK_6));

        cdLibrary.add(cd1);
        cdLibrary.add(cd2);
        cdLibrary.add(cd3);
        cdLibrary.add(cd4);

        //cdLibrary.saveToFile("testlibrary");

    }

    private CD createCD(String str){
        String[] elements = str.split(";");
        return new CDBuilder().setTitle(elements[0]).setArtist(elements[1]).setReleaseYear(Integer.parseInt(elements[2])).setProducer(elements[3])
                .setGenre(Genre.valueOf(elements[4])).setOriginal("true".equals(elements[5])).setDiscCount(Integer.parseInt(elements[6])).build();
    }

    private Track createTrack(String str){
        String [] el = str.split(";");
        return new TrackBuilder().setTitle(el[0]).setArtist(el[1]).setTime(Integer.parseInt(el[2])).setGenre(Genre.valueOf(el[3])).buildTrack();
    }



    @Test
    void testFindCDByGenreShouldReturnOneCD() {

        List<CD> result = cdLibrary.findByGenre(Genre.FOLK);
        assertEquals(1, result.size());
        assertEquals(Genre.FOLK, result.get(0).getGenre());

    }


    @Test
    void testFindCDByGenreShouldReturnTwoCD() {

        List<CD> result = cdLibrary.findByGenre(Genre.AMBIENT);
        assertEquals(2, result.size());
        assertEquals(Genre.AMBIENT, result.get(0).getGenre());

    }

    @Test
    void testFindCDByGenreShouldEmptyList() {

        List<CD> result = cdLibrary.findByGenre(Genre.CLASSICAL);
        assertEquals(0, result.size());
    }

    @Test
    void testfindCDByTrackTitleShouldReturnCD(){
        List<CD> result = cdLibrary.findCDByTrackTitle("a");
        assertEquals(2, result.size());;
        Assertions.assertTrue(result.get(1).getTracks().stream().anyMatch(track -> track.getTitle().toLowerCase().contains("a")));
    }

    @Test
    void testfindCDByTrackTitleShouldReturnEmptyList(){

        assertEquals(0, cdLibrary.findTrackByTitle("none").size());
    }

    @Test
    void testfindTrackByTitleShouldReturnTitle(){
        List<Track> result = cdLibrary.findTrackByTitle("a");
        assertEquals(2, result.size());
        Assertions.assertTrue(result.get(1).getTitle().contains("a"));
    }


    @Test
    void testfindTrackByTitleShouldReturnEmptyList(){

        assertEquals(0, cdLibrary.findTrackByTitle("none").size());
    }

    @Test
    void testfindByTitleShouldReturnTitle(){
        List<CD> result = cdLibrary.findByTitle("tle2");
        assertEquals(1, result.size());
        Assertions.assertTrue(result.get(0).getTitle().contains("tle2"));
    }

    @Test
    void testFindByArtistShouldReturnList(){
        List<CD> result = cdLibrary.findByArtist("AAA");
        Assertions.assertTrue(result.get(1).getArtist().contains("AAA"));



    }

    @Test
    void testfindAllArtistShouldReturnSetWithAllArtist(){
        Set<String> result = cdLibrary.findAllArtist();

        Assertions.assertTrue(result.size() == 3);
        Assertions.assertTrue(result.contains("AAA"));
        Assertions.assertTrue(result.contains("BBB"));
        Assertions.assertTrue(result.contains("CCC"));


    }

    @Test
    void testLoadFromFile(){
        //wczytać testlibrary.txt do drugiej cd library

        CDLibrary libraryFromFile = new CDLibrary();

        String path = this.getClass().getResource("/testlibrary.txt").getPath();
        libraryFromFile.loadFromFile(path);
        assertEquals(cdLibrary.getCDs().size(), libraryFromFile.getCDs().size());
        for(int i = 0; i < cdLibrary.getCDs().size(); i++){
            assertEquals(cdLibrary.getCDs().get(i), libraryFromFile.getCDs().get(i));
        }
    }

    @Test
    void testSaveFromFile() throws IOException {
        String directoryPath = this.getClass().getResource("/").getPath();
        cdLibrary.saveToFile(directoryPath + "savedlibrary.txt");
        File testFile = new File(directoryPath + "testlibrary.txt");
        File savedFile = new File(directoryPath + "savedlibrary.txt");

        assertTrue(FileUtils.contentEquals(testFile, savedFile));
    }

    @Test
    void testAddCD(){
        CDLibrary newCDLibrary = new CDLibrary();
        assertTrue(newCDLibrary.getCDs().isEmpty());

        CD newCD = createCD(STRINGCD_1);
        newCDLibrary.add(newCD);
        assertEquals(1, newCDLibrary.getCDs().size());
        assertEquals(newCD, newCDLibrary.getCDs().get(0));
    }
}
