package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.model.entities.GeoCoordinateModelEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private String hopType;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @OneToOne
    @JoinColumn(name = "fk_locationCoordinates")
    private GeoCoordinateEntity locationCoordinates;
}
