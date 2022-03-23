package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@Slf4j
@GraphQLApi
@RequiredArgsConstructor
public class SearchQueryResolver {

    private final SearchService searchService;

    //@Query
    public List<Object> getSearch(String name) {
        return searchService.search(name);
    }
}
