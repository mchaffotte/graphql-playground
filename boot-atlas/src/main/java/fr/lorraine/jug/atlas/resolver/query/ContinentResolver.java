package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.connection.CursorService;
import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.service.ContinentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("ContinentQueryResolver")
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLQueryResolver {

    private final ContinentService continentService;

    private final CursorService cursorService;

    public Continent continent(final String name) {
        return continentService.getContinent(name);
    }

    public Connection<Continent> continents(final int first, final String cursor) {
        final List<Continent> continents;
        if (cursor == null) {
            continents = continentService.getContinents();
        } else {
            continents = continentService.getContinentsAfter(cursorService.decode(cursor));
        }

        final List<Edge<Continent>> edges = continents
                .stream()
                .map(continent -> new DefaultEdge<>(continent, cursorService.encode(continent.getId())))
                .limit(first)
                .collect(Collectors.toUnmodifiableList());

        final ConnectionCursor firstCursor = cursorService.getFirstCursor(edges);
        final ConnectionCursor lastCursor = cursorService.getLastCursor(edges);
        final DefaultPageInfo pageInfo = new DefaultPageInfo(firstCursor, lastCursor, cursor != null, edges.size() >= first);
        return new DefaultConnection<>(edges, pageInfo);
    }

}
