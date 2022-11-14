package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WarehouseMapperTest
{
    @Test
    void testEntityToDto()
    {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId(1);
        warehouseEntity.setLevel(5);
        warehouseEntity.setCode("123456Test1");
        warehouseEntity.setDescription("BeschreibungWarehouse");

        Warehouse warehouse = WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);

        Assertions.assertEquals(warehouse.getLevel(), warehouseEntity.getLevel());
        Assertions.assertEquals(warehouse.getCode(), warehouseEntity.getCode());
        Assertions.assertEquals(warehouse.getDescription(), warehouseEntity.getDescription());
    }

    @Test
    void testDtoToEntity()
    {
        Warehouse warehouse = new Warehouse();
        warehouse.setLevel(3);
        warehouse.setCode("CodeBlack");
        warehouse.setDescription("describingWarehouse");

        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);

        Assertions.assertEquals(warehouse.getLevel(), warehouseEntity.getLevel());
        Assertions.assertEquals(warehouse.getCode(), warehouseEntity.getCode());
        Assertions.assertEquals(warehouse.getDescription(), warehouseEntity.getDescription());
    }

}