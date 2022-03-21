package fr.lorraine.jug.bootatlas.resolver.query;

import fr.lorraine.jug.bootatlas.service.SearchService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SearchResultResolver implements GraphQLQueryResolver {

    private final SearchService searchService;

    public SearchResultResolver(final SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Object> search(final String contains) {
        return searchService.search(contains);
    }

}
