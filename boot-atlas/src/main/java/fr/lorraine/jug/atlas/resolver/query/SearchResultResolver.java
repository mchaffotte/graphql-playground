package fr.lorraine.jug.atlas.resolver.query;

import fr.lorraine.jug.atlas.service.SearchService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SearchResultResolver implements GraphQLQueryResolver {

    private final SearchService searchService;

    public List<Object> search(final String contains) {
        return searchService.search(contains);
    }

}
