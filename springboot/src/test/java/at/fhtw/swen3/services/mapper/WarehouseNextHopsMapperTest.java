package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopModelEntity;
import at.fhtw.swen3.model.entities.WarehouseNextHopsModelEntity;
import at.fhtw.swen3.persistence.entity.HopEntity;
import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseNextHopsMapperTest
{
    @Test
    void testEntityToDto()
    {
        HopEntity hopEntity = new HopEntity();
        hopEntity.setProcessingDelayMins(12);
        hopEntity.setHopType("Hoppi");
        hopEntity.setLocationName("Location 0022");

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();
        warehouseNextHopsEntity.setHop(hopEntity);

        WarehouseNextHops warehouseNextHops = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        Assertions.assertEquals(warehouseNextHops.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        Assertions.assertEquals(warehouseNextHops.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        Assertions.assertEquals(warehouseNextHops.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
    }

    @Test
    void testDtoToEntity()
    {
        Hop hop = new Hop();
        hop.setProcessingDelayMins(12);
        hop.setHopType("Hoppi");
        hop.setLocationName("Location 0022");

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();
        warehouseNextHops.setHop(hop);

        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHops);

        Assertions.assertEquals(warehouseNextHops.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        Assertions.assertEquals(warehouseNextHops.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        Assertions.assertEquals(warehouseNextHops.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
    }

    @Test
    void testEntityToDal()
    {
        HopEntity hopEntity = new HopEntity();
        hopEntity.setProcessingDelayMins(12);
        hopEntity.setHopType("Hoppi");
        hopEntity.setLocationName("Location 0022");

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();
        warehouseNextHopsEntity.setHop(hopEntity);

        WarehouseNextHopsModelEntity warehouseNextHopsModelEntity = WarehouseNextHopsMapper.INSTANCE.entityToDal(warehouseNextHopsEntity);

        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
    }

    @Test
    void testDalToEntity()
    {
        HopModelEntity hopModelEntity = new HopModelEntity();
        hopModelEntity.setProcessingDelayMins(12);
        hopModelEntity.setHopType("Hoppi");
        hopModelEntity.setLocationName("Location 0022");

        WarehouseNextHopsModelEntity warehouseNextHopsModelEntity = new WarehouseNextHopsModelEntity();
        warehouseNextHopsModelEntity.setHop(hopModelEntity);

        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dalToEntity(warehouseNextHopsModelEntity);

        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        Assertions.assertEquals(warehouseNextHopsModelEntity.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
    }


}