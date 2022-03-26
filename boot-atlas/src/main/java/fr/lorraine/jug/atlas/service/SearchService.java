package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final CountryRepository countryRepository;

    public List<Object> search(final String contains) {
        return this.countryRepository.search(contains);
    }
}
