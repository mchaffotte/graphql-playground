package fr.lorraine.jug.bootatlas.service;

import fr.lorraine.jug.bootatlas.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {

    private final CountryRepository countryRepository;

    public SearchService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Object> search(String name) {
        return this.countryRepository.search(name);
    }
}
