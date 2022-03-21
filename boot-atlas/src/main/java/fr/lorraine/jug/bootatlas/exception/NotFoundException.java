package fr.lorraine.jug.bootatlas.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("The country does not exist.");
    }
}
