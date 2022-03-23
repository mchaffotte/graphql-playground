package fr.lorraine.jug.bootatlas.resolver;

import fr.lorraine.jug.bootatlas.domain.Continent;
import fr.lorraine.jug.bootatlas.domain.Country;
import fr.lorraine.jug.bootatlas.repository.CountryRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLResolver<Continent> {

    private final CountryRepository countryRepository;

    public List<Country> countries(final Continent continent, final Integer first, final Integer offset) {
        return countryRepository.getCountriesOfContinent(continent.getName(), first, offset);
    }

}
