package at.fhtw.swen3.gps.service;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Address {
    //street
    private String street;
    //post code
    private String postalCode;
    //city
    private String city;
    //country
    private String country;

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Address() {

    }
}
