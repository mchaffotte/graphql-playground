package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.context.dataloader.DataLoaderRegistryFactory;
import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.service.AreaService;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class CountryResolver implements GraphQLResolver<Country> {

    private final AreaService areaService;

    public long area(final Country country, final AreaUnit unit) {
        log.info("Getting area of {}", country.getName());
        return areaService.getArea(country, unit);
    }

//    public CompletableFuture<Long> area(final Country country, final AreaUnit unit, final DataFetchingEnvironment environment) {
//        final DataLoader<String, Long> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.AREA_DATA_LOADER);
//        return dataLoader.load(country.getCode());
//    }

//    public DataFetcherResult<Long> area(final Country country, final AreaUnit unit) {
//        return DataFetcherResult.<Long>newResult().data(
//                areaService.getArea(country, unit)
//                )
//                .error(new GenericGraphQLError("Could not load sub data"))
//                .build();
//    }

}
