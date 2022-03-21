package fr.lorraine.jug.bootatlas.service;


import fr.lorraine.jug.bootatlas.domain.Continent;
import fr.lorraine.jug.bootatlas.exception.NotFoundException;
import fr.lorraine.jug.bootatlas.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContinentService {

    private final CountryRepository countryRepository;

    public ContinentService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Continent getContinent(String name) {
        final Optional<Continent> country = countryRepository.getContinent(name);
        return country.orElseThrow(NotFoundException::new);
    }
}
