package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
@Entity
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    @Pattern(regexp = "[A-Z ][a-zA-Z \\/\\-]*")
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column
    @Pattern(regexp = "[A-Z ][a-zA-Z ]+\\s[0-9a-z\\/\\-]+")
    @NotNull(message = "Street can not be null!")
    private String street;

    @Column
    @Pattern(regexp = "A-+[0-9]{4}")
    @NotNull(message = "Postal code can not be null!")
    private String postalCode;

    @Column
    @Pattern(regexp = "[A-Z ][a-zA-Z \\/\\-]*")
    @NotNull(message = "City can not be null!")
    private String city;

    @Column
    @NotNull(message = "Country can not be null!")
    private String country;
}
