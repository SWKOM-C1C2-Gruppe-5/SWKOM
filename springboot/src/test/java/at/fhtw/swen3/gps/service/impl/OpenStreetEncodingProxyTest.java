package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpenStreetEncodingProxyTest {
    OpenStreetEncodingProxy proxy = new OpenStreetEncodingProxy();

    @Test
    public void testEncodeAddressSuccess() throws BLValidationException {
        Address address = new Address();
        address.setStreet("87/Aspernstraße");
        address.setPostalCode("1220");
        address.setCity("Vienna");
        address.setCountry("Austria");
        GeoCoordinateEntity geo = proxy.encodeAddress(address);
        assertNotNull(geo);
        assertNotNull(geo.getLat());
        assertNotNull(geo.getLon());
    }

    @Test
    public void testEncodeAddressFail() {
        Address address = new Address("Invalid street", "Invalid postal code", "Invalid city", "Invalid country");
        BLValidationException exception = assertThrows(BLValidationException.class, () -> {
            proxy.encodeAddress(address);
        });
        assertEquals("The address of sender or receiver was not found.", exception.getMessage());
    }
}