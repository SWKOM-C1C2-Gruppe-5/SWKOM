package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter @Setter
@Entity
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "fk_visitedHops")
    private ParcelEntity visitedHops;

    @ManyToOne
    @JoinColumn(name = "fk_futureHops")
    private ParcelEntity futureHops;
}
