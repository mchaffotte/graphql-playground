package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CountryContext {

    Country country;

    AreaUnit unit;
}
