package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class ParcelEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private Float weight;

    @OneToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;

    @OneToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;

    @Column
    private String trackingId;

    @Column
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "visitedHops")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy = "futureHops")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
