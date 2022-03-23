package fr.lorraine.jug.atlas.resolver.mutation;

import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.domain.input.CountryInput;
import fr.lorraine.jug.atlas.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.validation.Valid;

@GraphQLApi
@RequiredArgsConstructor
public class CountryMutationResolver {

    private final CountryService countryService;

    @Mutation
    public Country addCountry(@Valid final CountryInput country) {
        return countryService.addCountry(country);
    }

    @Mutation
    public boolean deleteCountry(final String code) {
        return countryService.deleteCountry(code);
    }

}
