package ch.guillod.apps.band.manager;

import ch.guillod.apps.band.manager.domain.Membership;
import ch.guillod.apps.band.manager.domain.Musician;
import org.junit.Assert;
import org.junit.Test;

import java.time.Period;
import java.time.Year;
import java.util.*;

public class PeriodTests {

    @Test
    public void periodTest() {
        Period period = Period.between(Year.of(2002).atDay(1), Year.of(2018).atDay(1));
        System.out.println(period.getYears());
    }

    @Test
    public void membershipTest() {
        Musician musician = new Musician();

        // 7
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(1983), Year.of(1990)));
        // 3 (0 counts)
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(1985), Year.of(1988)));
        // 5
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(1995), Year.of(2000)));
        // 8 (only 5 count)
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(1997), Year.of(2005)));
        // 7
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(2010), Year.of(2017)));
        // 3 (only 1 counts)
        musician.getMemberships().add(new Membership("Avenir Bas-Vully", Year.of(2015), null));
        // Total = 25

        Assert.assertEquals(25, musician.getMusicYears(Year.of(2018)));
    }

    private void addYears(Set<Year> years, Year start, Year end){
        while(start.isBefore(end)){
            years.add(start);
            start = start.plusYears(1);
        }
    }

}
