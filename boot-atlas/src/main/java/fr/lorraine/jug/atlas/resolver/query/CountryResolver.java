package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.service.CountryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("CountryQueryResolver")
@RequiredArgsConstructor
public class CountryResolver implements GraphQLQueryResolver {

    private final CountryService countryService;

    public List<Country> countries() {
        log.info("Retrieving countries");
        return countryService.getAllCountries();
    }

    public Country country(final String code) {
        return countryService.getCountry(code);
    }

}
