package fr.lorraine.jug.atlas.resolver;

import fr.lorraine.jug.atlas.domain.AreaUnit;
import fr.lorraine.jug.atlas.domain.Country;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class CountryResolver {

    public long area(@Source final Country country, final AreaUnit unit) {
        if(unit == AreaUnit.SQUARE_MILE) {
            return Math.round(country.getTotalArea() / 2.58998811034);
        }
        return country.getTotalArea();
    }
}
