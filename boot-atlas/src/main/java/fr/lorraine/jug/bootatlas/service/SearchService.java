package fr.lorraine.jug.bootatlas.service;

import fr.lorraine.jug.bootatlas.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {

    private final CountryRepository countryRepository;

    public SearchService(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Object> search(final String contains) {
        return this.countryRepository.search(contains);
    }
}
