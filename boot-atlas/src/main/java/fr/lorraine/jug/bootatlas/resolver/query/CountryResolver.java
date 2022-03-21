package fr.lorraine.jug.bootatlas.resolver.query;

import fr.lorraine.jug.bootatlas.domain.Country;
import fr.lorraine.jug.bootatlas.service.CountryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("CountryQueryResolver")
public class CountryResolver implements GraphQLQueryResolver {

    private final CountryService countryService;

    public CountryResolver(final CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> countries() {
        log.info("Retrieving countries");
        return countryService.getAllCountries();
    }

    public Country country(final String code) {
        return countryService.getCountry(code);
    }

}
