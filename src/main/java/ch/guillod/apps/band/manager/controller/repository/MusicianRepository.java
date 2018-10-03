package ch.guillod.apps.band.manager.controller.repository;

import ch.guillod.apps.band.manager.domain.Musician;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "musician", path = "musician")
public interface MusicianRepository extends PagingAndSortingRepository<Musician, Long> {

    List<Musician> findByLastname(@Param("lastname") String lastname);

}
