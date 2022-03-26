package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.exception.NotFoundException;
import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContinentService {

    private final CountryRepository countryRepository;

    public Continent getContinent(final String name) {
        final Optional<Continent> country = countryRepository.getContinent(name);
        return country.orElseThrow(NotFoundException::new);
    }

    public List<Continent> getContinents() {
        return countryRepository.getContinents();
    }

    public List<Continent> getContinentsAfter(final UUID id) {
        return countryRepository.getContinentsAfter(id);
    }
}
