package fr.lorraine.jug.bootatlas.resolver.mutation;

import fr.lorraine.jug.bootatlas.domain.Country;
import fr.lorraine.jug.bootatlas.domain.input.CountryInput;
import fr.lorraine.jug.bootatlas.service.CountryService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class CountryMutationResolver implements GraphQLMutationResolver {

    private final CountryService countryService;

    public CountryMutationResolver(final CountryService countryService) {
        this.countryService = countryService;
    }

    public Country addCountry(final CountryInput country) {
        return countryService.addCountry(country);
    }

    public boolean deleteCountry(final String code) {
        return countryService.deleteCountry(code);
    }
}
