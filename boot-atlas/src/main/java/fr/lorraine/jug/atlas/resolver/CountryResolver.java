package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class CountryResolver implements GraphQLResolver<Country> {

    public long area(final Country country, final AreaUnit unit) {
        if (unit == AreaUnit.SQUARE_MILE) {
            return Math.round(country.getTotalArea() / 2.58998811034);
        }
        return country.getTotalArea();
    }

}
