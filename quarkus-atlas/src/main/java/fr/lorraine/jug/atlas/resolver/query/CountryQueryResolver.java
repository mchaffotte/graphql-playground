package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@Slf4j
@GraphQLApi
@RequiredArgsConstructor
public class CountryQueryResolver {

    private final CountryService countryService;

    @Query
    @Description("Get all Films from a galaxy far far away")
    public List<Country> getCountries() {
        log.info("Retrieving countries");
        return countryService.getAllCountries();
    }

    @Query
    public Country getCountry(final String code) {
        return countryService.getCountry(code);
    }

}
