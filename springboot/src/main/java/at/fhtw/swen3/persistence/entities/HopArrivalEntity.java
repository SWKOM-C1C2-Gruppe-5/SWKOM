package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter @Setter
@Entity
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull(message = "Code can not be null!")
    private String code;

    @Column
    @Pattern(regexp = "[A-Z ][a-zA-Z0-9 \\/\\-]*")
    @NotNull(message = "Description can not be null!")
    private String description;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Date/Time can not be null!")
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "fk_visitedHops")
    private ParcelEntity visitedHops;

    @ManyToOne
    @JoinColumn(name = "fk_futureHops")
    private ParcelEntity futureHops;
}
