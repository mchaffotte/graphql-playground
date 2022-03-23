package fr.lorraine.jug.atlas.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("The resource does not exist.");
    }
}
