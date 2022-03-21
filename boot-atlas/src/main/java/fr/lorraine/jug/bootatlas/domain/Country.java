package fr.lorraine.jug.bootatlas.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Country {

    String code;

    String name;

    String capital;

    long totalArea;

}
