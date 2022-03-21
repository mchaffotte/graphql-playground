package fr.lorraine.jug.bootatlas.resolver.query;

import fr.lorraine.jug.bootatlas.domain.Continent;
import fr.lorraine.jug.bootatlas.service.ContinentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("ContinentQueryResolver")
public class ContinentResolver implements GraphQLQueryResolver {

    private final ContinentService continentService;

    public ContinentResolver(final ContinentService continentService) {
        this.continentService = continentService;
    }

    public Continent continent(final String name) {
        return continentService.getContinent(name);
    }

}
