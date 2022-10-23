package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class WarehouseNextHopsModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private Integer traveltimeMins;

    @OneToOne
    @JoinColumn(name = "fk_hop")
    private HopModelEntity hop;
}
