package fr.lorraine.jug.atlas.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class Continent {

    UUID id;

    String name;

}
