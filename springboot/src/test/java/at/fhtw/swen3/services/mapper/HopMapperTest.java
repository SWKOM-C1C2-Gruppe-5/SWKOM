package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopModelEntity;
import at.fhtw.swen3.persistence.entity.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopMapperTest
{
    @Test
    void testEntityToDto()
    {
        HopEntity hopEntity = new HopEntity();
        hopEntity.setHopType("type 1");
        hopEntity.setCode("Code Hallo 11 99 --");
        hopEntity.setDescription("description how R U");
        hopEntity.setLocationName("Best Location");
        hopEntity.setProcessingDelayMins(12);

        Hop hop = HopMapper.INSTANCE.entityToDto(hopEntity);

        Assertions.assertEquals(hop.getCode(), hopEntity.getCode());
        Assertions.assertEquals(hop.getHopType(), hopEntity.getHopType());
        Assertions.assertEquals(hop.getDescription(), hopEntity.getDescription());
        Assertions.assertEquals(hop.getLocationName(), hopEntity.getLocationName());
        Assertions.assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }

    @Test
    void testDtoToEntity()
    {
        Hop hop = new Hop();
        hop.setHopType("type 1");
        hop.setCode("Code Hallo 11 99 --");
        hop.setDescription("description how R U");
        hop.setLocationName("Best Location");
        hop.setProcessingDelayMins(12);

        HopEntity hopEntity = HopMapper.INSTANCE.dtoToEntity(hop);

        Assertions.assertEquals(hop.getCode(), hopEntity.getCode());
        Assertions.assertEquals(hop.getHopType(), hopEntity.getHopType());
        Assertions.assertEquals(hop.getDescription(), hopEntity.getDescription());
        Assertions.assertEquals(hop.getLocationName(), hopEntity.getLocationName());
        Assertions.assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }

    @Test
    void testEntityToDal()
    {
        HopEntity hopEntity = new HopEntity();
        hopEntity.setHopType("type 1");
        hopEntity.setCode("Code Hallo 11 99 --");
        hopEntity.setDescription("description how R U");
        hopEntity.setLocationName("Best Location");
        hopEntity.setProcessingDelayMins(12);

        HopModelEntity hopModelEntity = HopMapper.INSTANCE.entityToDal(hopEntity);

        Assertions.assertEquals(hopModelEntity.getCode(), hopEntity.getCode());
        Assertions.assertEquals(hopModelEntity.getHopType(), hopEntity.getHopType());
        Assertions.assertEquals(hopModelEntity.getDescription(), hopEntity.getDescription());
        Assertions.assertEquals(hopModelEntity.getLocationName(), hopEntity.getLocationName());
        Assertions.assertEquals(hopModelEntity.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }

    @Test
    void testDalToEntity()
    {
        HopModelEntity hopModelEntity = new HopModelEntity();
        hopModelEntity.setHopType("type 1");
        hopModelEntity.setCode("Code Hallo 11 99 --");
        hopModelEntity.setDescription("description how R U");
        hopModelEntity.setLocationName("Best Location");
        hopModelEntity.setProcessingDelayMins(12);

        HopEntity hopEntity = HopMapper.INSTANCE.dalToEntity(hopModelEntity);

        Assertions.assertEquals(hopModelEntity.getCode(), hopEntity.getCode());
        Assertions.assertEquals(hopModelEntity.getHopType(), hopEntity.getHopType());
        Assertions.assertEquals(hopModelEntity.getDescription(), hopEntity.getDescription());
        Assertions.assertEquals(hopModelEntity.getLocationName(), hopEntity.getLocationName());
        Assertions.assertEquals(hopModelEntity.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }

}