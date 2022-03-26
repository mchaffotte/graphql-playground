package fr.lorraine.jug.atlas.context.dataloader;

import fr.lorraine.jug.atlas.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    public static final String AREA_DATA_LOADER = "AREA_DATA_LOADER";
    private static final Executor areaThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final AreaService areaService;

    public DataLoaderRegistry create() {
        final DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register(AREA_DATA_LOADER, createAreaDataLoader());
        return registry;
    }

    private DataLoader<String,Long> createAreaDataLoader() {
        return DataLoaderFactory.newMappedDataLoader((countryCodes, environment) ->
                CompletableFuture.supplyAsync(() ->
                        areaService.getAreaFor((Map) environment.getKeyContexts()),
                        areaThreadPool));
    }
}
