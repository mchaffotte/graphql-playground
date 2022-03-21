package fr.lorraine.jug.bootatlas.service;

import fr.lorraine.jug.bootatlas.domain.Country;
import fr.lorraine.jug.bootatlas.exception.NotFoundException;
import fr.lorraine.jug.bootatlas.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(final String code) {
        final Optional<Country> country = countryRepository.getCountry(code);
        return country.orElseThrow(NotFoundException::new);
    }
}
