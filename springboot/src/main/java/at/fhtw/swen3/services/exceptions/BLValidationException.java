package at.fhtw.swen3.services.exceptions;

public class BLValidationException extends BLException {

    public BLValidationException(Exception innerException, String errorMessage) {
        super(innerException, errorMessage);
    }
}
