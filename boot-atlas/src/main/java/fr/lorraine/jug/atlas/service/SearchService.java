package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchService {

    private final CountryRepository countryRepository;

    public List<Object> search(final String contains) {
        return this.countryRepository.search(contains);
    }
}
