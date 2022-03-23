package fr.lorraine.jug.atlas.repository;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.exception.NotFoundException;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class CountryRepository {

    private final Map<Continent, List<Country>> continents = new HashMap<>();

    private final List<Country> countries = new ArrayList<>();

    public CountryRepository() {
        final Country france = Country.builder()
                .code("FR")
                .name("France")
                .capital("Paris")
                .totalArea(672051)
                .build();
        countries.add(france);

        final Country allemagne = Country.builder()
                .code("DE")
                .name("Allemagne")
                .capital("Berlin")
                .totalArea(357588).build();
        countries.add(allemagne);

        final Country italie = Country.builder()
                .code("IT")
                .name("Italie")
                .capital("Rome")
                .totalArea(301336).build();
        countries.add(italie);

        final Continent europe = Continent.builder()
                .name("Europe")
                .build();
        continents.put(europe, List.of(france, allemagne, italie));
        final Continent afrique = Continent.builder()
                .name("Afrique").build();
        continents.put(afrique, List.of());
        final Continent asie = Continent.builder()
                .name("Asie").build();
        continents.put(asie, List.of());
    }

    public Optional<Continent> getContinent(final String name) {
        return continents.keySet().stream()
                .filter(continent -> continent.getName().equals(name))
                .findFirst();
    }

    public List<Country> getCountriesOfContinent(final String name, final Integer first, final Integer offset) {
        final List<Country> countries = continents.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(name))
                .map(Map.Entry::getValue)
                .findFirst().orElseThrow(NotFoundException::new);

        final int fromIndex = first != null && first > 0 ? first : 0;
        final int toIndex = offset != null && offset > 0 ? offset : 3;
        return countries.subList(fromIndex, toIndex);
    }

    public List<Country> findAll() {
        return countries;
    }

    public Optional<Country> getCountry(final String code) {
        return countries.stream()
                .filter(country -> country.getCode().equals(code))
                .findFirst();
    }

    public List<Object> search(final String contains) {
        final List<Continent> continents = this.continents.keySet().stream()
                .filter(continent -> continent.getName().contains(contains))
                .collect(Collectors.toList());
        final List<Country> countries = this.countries.stream()
                .filter(country -> country.getName().contains(contains))
                .collect(Collectors.toList());
        final List<Object> results = new ArrayList<>();
        results.addAll(continents);
        results.addAll(countries);
        return results;
    }

    public Country saveCountry(final Country newCountry) {
        countries.add(newCountry);
        return newCountry;
    }

    public boolean deleteCountry(final Country country) {
        return countries.remove(country);
    }
}
