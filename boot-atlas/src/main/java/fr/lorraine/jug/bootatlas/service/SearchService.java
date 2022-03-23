package fr.lorraine.jug.bootatlas.service;

import fr.lorraine.jug.bootatlas.repository.CountryRepository;
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
