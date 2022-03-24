package fr.lorraine.jug.atlas.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Continent implements SearchResult {

    String name;

}
