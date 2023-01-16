package at.fhtw.swen3.services.exceptions;

public class BLNotFoundException extends BLException {

    public BLNotFoundException(Exception innerException, String errorMessage) {
        super(innerException, errorMessage);
    }
}
