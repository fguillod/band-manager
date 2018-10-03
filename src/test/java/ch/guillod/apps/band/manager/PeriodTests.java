package ch.guillod.apps.band.manager;

import ch.guillod.apps.band.manager.domain.Membership;
import ch.guillod.apps.band.manager.domain.Musician;
import org.junit.Assert;
import org.junit.Test;

import java.time.Year;

public class PeriodTests {

    @Test
    public void membershipTest() {
        Musician musician = new Musician();

        String band = "Avenir Bas-Vully";

        // 7
        musician.getMemberships().add(new Membership(band, Year.of(1983), Year.of(1990)));
        // 3 (0 counts)
        musician.getMemberships().add(new Membership(band, Year.of(1985), Year.of(1988)));
        // 5
        musician.getMemberships().add(new Membership(band, Year.of(1995), Year.of(2000)));
        // 8 (only 5 count)
        musician.getMemberships().add(new Membership(band, Year.of(1997), Year.of(2005)));
        // 7
        musician.getMemberships().add(new Membership(band, Year.of(2010), Year.of(2017)));
        // 3 (only 1 counts)
        musician.getMemberships().add(new Membership(band, Year.of(2015), null));
        // Total = 25

        Assert.assertEquals(25, musician.getMusicYears(Year.of(2018)));
    }

}
