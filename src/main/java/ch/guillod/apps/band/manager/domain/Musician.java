package ch.guillod.apps.band.manager.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Musician extends Person {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Instrument> instruments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Membership> memberships = new ArrayList<>();

    public Musician() {
    }

    public Musician(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public int getMusicYears(){
        return getMusicYears(Year.now());
    }

    public int getMusicYears(Year end){
        Set<Year> years = new HashSet<>();

        for (Membership membership : memberships) {
            if (membership.getStart() != null) {
                if(membership.getEnd() != null){
                    addYears(years, membership.getStart(), membership.getEnd());
                }else{
                    addYears(years, membership.getStart(), end);
                }
            }
        }

        return years.size();
    }

    private void addYears(Set<Year> years, Year start, Year end){
        while(start.isBefore(end)){
            years.add(start);
            start = start.plusYears(1);
        }
    }
}
