package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.domain.input.CountryInput;
import fr.lorraine.jug.atlas.exception.NotFoundException;
import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(final String code) {
        final Optional<Country> country = countryRepository.getCountry(code);
        return country.orElseThrow(NotFoundException::new);
    }

    public Country addCountry(final CountryInput country) {
        final Country newCountry = Country.builder()
                .code(country.getCode())
                .name(country.getName())
                .capital(country.getCapital())
                .totalArea(country.getArea())
                .build();
        return countryRepository.saveCountry(newCountry);
    }

    public boolean deleteCountry(final String code) {
        final Optional<Country> country = countryRepository.getCountry(code);
        if (country.isEmpty()) {
            return false;
        }
        return countryRepository.deleteCountry(country.get());
    }
}
