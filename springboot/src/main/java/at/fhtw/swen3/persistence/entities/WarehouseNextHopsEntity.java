package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private Integer traveltimeMins;

    @OneToOne
    @JoinColumn(name = "fk_hop")
    private HopEntity hop;
}
