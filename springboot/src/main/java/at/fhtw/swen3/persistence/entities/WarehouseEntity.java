package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class WarehouseEntity extends HopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long id;

    @Column
    private Integer level;

    @OneToMany
    @JoinColumn(name = "fk_nextHops")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
