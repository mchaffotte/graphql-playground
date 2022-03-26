package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.resolver.CountryContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AreaService {

    public Map<String, Long> getAreaFor(final Map<String, CountryContext> countries) {
        log.info("Retrieving area for {}", countries.entrySet());
        return countries.values()
                .stream()
                .collect(Collectors.toMap(context -> context.getCountry().getCode(), this::area));
    }

    private long area(final CountryContext country) {
        return getArea(country.getCountry(), country.getUnit());
    }

    public long getArea(final Country country, final AreaUnit unit) {
        if (unit == AreaUnit.SQUARE_MILE) {
            return Math.round(country.getTotalArea() / 2.58998811034);
        }
        return country.getTotalArea();
    }
}
