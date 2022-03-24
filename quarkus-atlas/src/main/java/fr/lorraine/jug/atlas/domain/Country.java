package fr.lorraine.jug.atlas.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Country implements SearchResult {

    String code;

    String name;

    String capital;

    long totalArea;

}
