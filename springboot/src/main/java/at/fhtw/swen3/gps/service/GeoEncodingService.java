package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.exceptions.BLValidationException;

public interface GeoEncodingService {
        GeoCoordinateEntity encodeAddress(Address a) throws BLValidationException;
}
