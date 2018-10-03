package ch.guillod.apps.band.manager.controller;

import ch.guillod.apps.band.manager.controller.repository.MusicianRepository;
import ch.guillod.apps.band.manager.domain.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DistinctionController {

    private static final int[] DISTINCTION_YEARS = {25, 35, 40, 50, 60, 70};

    @Autowired
    private MusicianRepository musicianRepository;

    @GetMapping("/distinctions/{year}")
    public List<String> getAllDistinctions(@PathVariable(name = "year") Year year) {
        Iterable<Musician> musicians = musicianRepository.findAll();

        List<String> distinctions = new ArrayList<>();

        for (Musician musician : musicians) {
            if (hasDistinction(musician.getMusicYears(year))) {
                distinctions.add(String.format("%s %s gets a distinction for %d years of music in %s", musician.getFirstname(), musician.getLastname(), musician.getMusicYears(year), year.toString()));
            }
        }

        return distinctions;
    }

    private boolean hasDistinction(int years) {
        return Arrays.binarySearch(DISTINCTION_YEARS, years) >= 0;
    }
}
