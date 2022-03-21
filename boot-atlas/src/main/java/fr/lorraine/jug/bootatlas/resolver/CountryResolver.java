package fr.lorraine.jug.bootatlas.resolver;

import fr.lorraine.jug.bootatlas.domain.AreaUnit;
import fr.lorraine.jug.bootatlas.domain.Country;
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
