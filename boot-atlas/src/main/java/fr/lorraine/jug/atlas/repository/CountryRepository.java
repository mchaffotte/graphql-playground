package fr.lorraine.jug.atlas.repository;

import fr.lorraine.jug.atlas.domain.Continent;
import fr.lorraine.jug.atlas.domain.Country;
import fr.lorraine.jug.atlas.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CountryRepository {

    private final List<Continent> continents;

    private final List<Country> countries;

    private final Map<String, List<Country>> countriesOfContinents = new HashMap<>();

    public CountryRepository() {
        final Continent europe = Continent.builder()
                .id(UUID.fromString("417c04b2-02e9-4e67-8e2a-90809efae186"))
                .name("Europe").build();
        final Continent afrique = Continent.builder()
                .id(UUID.fromString("9562b70a-cd65-4ac4-8833-416941e34b62"))
                .name("Afrique").build();
        final Continent asie = Continent.builder()
                .id(UUID.fromString("a90d1aa4-2364-4def-914b-5c2942f6802e"))
                .name("Asie").build();
        continents = Stream.of(europe, afrique, asie)
                .sorted(Comparator.comparing(Continent::getName))
                .collect(Collectors.toList());

        final Country france = Country.builder()
                .code("FR")
                .name("France")
                .capital("Paris")
                .totalArea(672051).build();
        final Country allemagne = Country.builder()
                .code("DE")
                .name("Allemagne")
                .capital("Berlin")
                .totalArea(357588).build();
        final Country italie = Country.builder()
                .code("IT")
                .name("Italie")
                .capital("Rome")
                .totalArea(301336).build();
        final Country egypte = Country.builder()
                .code("EG")
                .name("Égypte")
                .capital("Le Caire")
                .totalArea(1001450).build();
        final Country senegal = Country.builder()
                .code("SN")
                .name("Sénégal")
                .capital("Dakar")
                .totalArea(196722).build();
        final Country botswana = Country.builder()
                .code("BW")
                .name("Botswana")
                .capital("Gaborone")
                .totalArea(581726).build();
        final Country nepal = Country.builder()
                .code("NP")
                .name("Népal")
                .capital("Katmandou")
                .totalArea(147516).build();
        final Country indonesie = Country.builder()
                .code("ID")
                .name("Indonésie")
                .capital("Jakarta")
                .totalArea(1904569).build();
        final Country japon = Country.builder()
                .code("JP")
                .name("Japon")
                .capital("Tokyo")
                .totalArea(377975).build();
        countries = Stream.of(france, allemagne, italie, egypte, senegal, botswana, nepal, indonesie, japon)
                .sorted(Comparator.comparing(Country::getCode))
                .collect(Collectors.toList());

        countriesOfContinents.put(europe.getName(), List.of(france, allemagne, italie));
        countriesOfContinents.put(afrique.getName(), List.of(egypte, senegal, botswana));
        countriesOfContinents.put(asie.getName(), List.of(nepal, indonesie, japon));
    }

    public Optional<Continent> getContinent(final String name) {
        return continents.stream()
                .filter(continent -> continent.getName().equals(name))
                .findFirst();
    }

    public List<Country> getCountriesOfContinent(final String name, final Integer first, final Integer offset) {
        final List<Country> countries = countriesOfContinents.entrySet().stream()
                .filter(entry -> entry.getKey().equals(name))
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
        final List<Continent> continents = this.continents.stream()
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

    public List<Continent> getContinents() {
        return continents;
    }

    public List<Continent> getContinentsAfter(final UUID id) {
        return continents.stream()
                .dropWhile(continent -> continent.getId().compareTo(id) <= 0)
                .collect(Collectors.toUnmodifiableList());
    }
}
