package at.fhtw.swen3.model.entities;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class WarehouseModelEntity extends HopModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private Integer level;

    @OneToMany
    @JoinColumn(name = "fk_nextHops")
    private List<WarehouseNextHopsModelEntity> nextHops = new ArrayList<>();
}
