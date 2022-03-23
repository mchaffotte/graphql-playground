package fr.lorraine.jug.bootatlas.domain.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CountryInput {

    @NotBlank
    String code;

    String name;

    String capital;

    long area;

}
