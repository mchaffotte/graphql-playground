package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.exception.NotFoundException;
import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ContinentService {

    private final CountryRepository countryRepository;

    public Continent getContinent(final String name) {
        final Optional<Continent> country = countryRepository.getContinent(name);
        return country.orElseThrow(NotFoundException::new);
    }
}
