package fr.lorraine.jug.atlas.resolver.mutation;

import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.domain.input.CountryInput;
import fr.lorraine.jug.atlas.service.CountryService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@RequiredArgsConstructor
@Validated
public class CountryMutationResolver implements GraphQLMutationResolver {

    private final CountryService countryService;

    public Country addCountry(@Valid final CountryInput country) {
        return countryService.addCountry(country);
    }

    public boolean deleteCountry(final String code) {
        return countryService.deleteCountry(code);
    }
}
