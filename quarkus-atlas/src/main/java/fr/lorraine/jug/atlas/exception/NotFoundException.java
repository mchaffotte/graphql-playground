package fr.lorraine.jug.atlas.exception;

import io.smallrye.graphql.api.ErrorCode;

@ErrorCode("not-found")
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("The country does not exist.");
    }
}
