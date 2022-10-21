package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class ParcelEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    @Pattern(regexp = "[0-9]*\\.?[0-9]*[1-9]")
    @NotNull(message = "Weight can not be null!")
    private Float weight;

    @OneToOne
    @JoinColumn(name = "fk_recipient")
    @NotNull(message = "Recipient can not be null!")
    private RecipientEntity recipient;

    @OneToOne
    @JoinColumn(name = "fk_sender")
    @NotNull(message = "Sender can not be null!")
    private RecipientEntity sender;

    @Column
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    @NotNull(message = "Tracking-ID can not be null!")
    private String trackingId;

    @Column
    @NotNull(message = "State can not be null!")
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "visitedHops")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy = "futureHops")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
