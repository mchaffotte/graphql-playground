package fr.lorraine.jug.atlas.context.dataloader;

import fr.lorraine.jug.atlas.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    public static final String AREA_DATA_LOADER = "AREA_DATA_LOADER";
    private static final Executor areaThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final AreaService areaService;

    public DataLoaderRegistry create(final String userId) {
        final DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register(AREA_DATA_LOADER, createAreaDataLoader(userId));
        return registry;
    }

    private DataLoader<String,Long> createAreaDataLoader(final String userId) {
        return DataLoaderFactory.newMappedDataLoader(countryCodes ->
                CompletableFuture.supplyAsync(() ->
                        areaService.getAreaFor(countryCodes, userId),
                        areaThreadPool));
    }
}
