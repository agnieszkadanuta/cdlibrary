package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CDTest {

    @Test

    void testGetTotalTime(){
        Track track1 = new TrackBuilder()
                .setTime(10)
                .buildTrack();
        Track track2 = new TrackBuilder()
                .setTime(20)
                .buildTrack();
        Track track3 = new TrackBuilder()
                .setTime(30)
                .buildTrack();
        CD cd = new CDBuilder()
                .addTrack(track1)
                .addTrack(track2)
                .addTrack(track3)
                .build();

        Assertions.assertEquals(60, cd.getTotalTime());

    }

}
