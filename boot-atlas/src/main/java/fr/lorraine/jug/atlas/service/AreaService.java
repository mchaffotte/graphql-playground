package fr.lorraine.jug.atlas.service;

import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AreaService {

    private final CountryService countryService;

    public Map<String, Long> getAreaFor(final Set<String> countryCodes, final String userId) {
        log.info("Retrieving area for {}", countryCodes);
        return countryCodes.stream()
                .collect(Collectors.toMap(code -> code, this::area));
    }

    private long area(final String countryCode) {
        Country country = countryService.getCountry(countryCode);
        return getArea(country, AreaUnit.SQUARE_METER);
    }

    public long getArea(Country country, AreaUnit unit) {
        if (unit == AreaUnit.SQUARE_MILE) {
            return Math.round(country.getTotalArea() / 2.58998811034);
        }
        return country.getTotalArea();
    }
}
