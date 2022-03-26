package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.service.ContinentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("ContinentQueryResolver")
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLQueryResolver {

    private final ContinentService continentService;

    public Continent continent(final String name) {
        return continentService.getContinent(name);
    }

    public List<Continent> continents() {
        return continentService.getContinents();
    }

}
