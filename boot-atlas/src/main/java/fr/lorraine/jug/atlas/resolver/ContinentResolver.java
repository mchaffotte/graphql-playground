package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.repository.CountryRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLResolver<Continent> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final CountryRepository countryRepository;

    public CompletableFuture<List<Country>> countries(final Continent continent, final Integer first, final Integer offset) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Retrieving countries of continent: {}", continent.getName());
            return countryRepository.getCountriesOfContinent(continent.getName(), first, offset);
        }, executorService);
    }

}
