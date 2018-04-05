package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDBuilderTest {

    @Test
    void testCDBuilder() {
        Track track1 = new TrackBuilder()
                .setTitle("title1")
                .buildTrack();
        Track track2 = new TrackBuilder()
                .setTitle("title2")
                .buildTrack();
        Track track3 = new TrackBuilder()
                .setTitle("title3")
                .buildTrack();
        CD cd = new CDBuilder()
                .setTitle("cd title")
                .addTrack(track1)
                .addTrack(track2)
                .addTrack(track3)
                .build();

        assertEquals("cd title", cd.getTitle());
        assertEquals(3, cd.getTracks().size(), "CD should has 3 tracks");
        assertEquals("title1", cd.getTracks().get(0).getTitle());
        assertEquals("title2", cd.getTracks().get(1).getTitle());
        assertEquals("title3", cd.getTracks().get(2).getTitle());
    }
}

