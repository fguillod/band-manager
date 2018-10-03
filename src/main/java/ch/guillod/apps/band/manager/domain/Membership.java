package ch.guillod.apps.band.manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Year;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Year start;
    private Year end;
    private String band;

    public Membership(){

    }

    public Membership(String band, Year start, Year end){
        this.band = band;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public Year getStart() {
        return start;
    }

    public void setStart(Year start) {
        this.start = start;
    }

    public Year getEnd() {
        return end;
    }

    public void setEnd(Year end) {
        this.end = end;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "start=" + start +
                ", end=" + end +
                ", band='" + band + '\'' +
                '}';
    }
}
