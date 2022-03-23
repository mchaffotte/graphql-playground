package fr.lorraine.jug.atlas.domain.input;

import lombok.Data;
import org.eclipse.microprofile.graphql.Input;

import javax.validation.constraints.NotBlank;

@Data
@Input("CountryInput")
public class CountryInput {

    @NotBlank
    String code;

    String name;

    String capital;

    long area;

}
