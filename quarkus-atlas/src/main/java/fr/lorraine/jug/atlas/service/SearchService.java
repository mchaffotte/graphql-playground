package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class SearchService {

    private final CountryRepository countryRepository;

    public List<Object> search(final String contains) {
        return this.countryRepository.search(contains);
    }
}
