package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Source;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class ContinentResolver {

    private final CountryRepository countryRepository;

    public List<Country> countries(@Source final Continent continent, final Integer first, final Integer offset) {
        return countryRepository.getCountriesOfContinent(continent.getName(), first, offset);
    }
}
