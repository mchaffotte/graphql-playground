package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.service.ContinentService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;

@GraphQLApi
@RequiredArgsConstructor
public class ContinentQueryResolver {

    private final ContinentService continentService;

    public Continent continent(final String name) {
        return continentService.getContinent(name);
    }

}
