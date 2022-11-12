package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransferwarehouseMapperTest
{
    @Test
    void testEntityToDto()
    {
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();
        transferwarehouseEntity.setCode("Codewort Hallo");
        transferwarehouseEntity.setDescription("Beschreibung super toll");
        transferwarehouseEntity.setHopType("Hip Hop");
        transferwarehouseEntity.setProcessingDelayMins(60);
        transferwarehouseEntity.setLogisticsPartner("Jacks & Partner");

        Transferwarehouse transferwarehouse = TransferwarehouseMapper.INSTANCE.entityToDto(transferwarehouseEntity);

        Assertions.assertEquals(transferwarehouseEntity.getCode(), transferwarehouse.getCode());
        Assertions.assertEquals(transferwarehouseEntity.getDescription(), transferwarehouse.getDescription());
        Assertions.assertEquals(transferwarehouseEntity.getHopType(), transferwarehouse.getHopType());
        Assertions.assertEquals(transferwarehouseEntity.getLogisticsPartner(), transferwarehouse.getLogisticsPartner());
        Assertions.assertEquals(transferwarehouseEntity.getProcessingDelayMins(), transferwarehouse.getProcessingDelayMins());
    }

    @Test
    void testDtoToEntity()
    {
        Transferwarehouse transferwarehouse = new Transferwarehouse();
        transferwarehouse.setCode("Codewort Hallo");
        transferwarehouse.setDescription("Beschreibung super toll");
        transferwarehouse.setHopType("Hip Hop");
        transferwarehouse.setProcessingDelayMins(60);
        transferwarehouse.setLogisticsPartner("Jacks & Partner");

        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);

        Assertions.assertEquals(transferwarehouseEntity.getCode(), transferwarehouse.getCode());
        Assertions.assertEquals(transferwarehouseEntity.getDescription(), transferwarehouse.getDescription());
        Assertions.assertEquals(transferwarehouseEntity.getHopType(), transferwarehouse.getHopType());
        Assertions.assertEquals(transferwarehouseEntity.getLogisticsPartner(), transferwarehouse.getLogisticsPartner());
        Assertions.assertEquals(transferwarehouseEntity.getProcessingDelayMins(), transferwarehouse.getProcessingDelayMins());
    }

}