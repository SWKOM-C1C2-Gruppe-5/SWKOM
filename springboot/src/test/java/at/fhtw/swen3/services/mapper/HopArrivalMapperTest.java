package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopArrivalModelEntity;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopArrivalMapperTest
{
    @Test
    void testEntityToDto()
    {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("Code 8899");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        hopArrivalEntity.setDescription("Description 5566");

        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        Assertions.assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        Assertions.assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
        Assertions.assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
    }

    @Test
    void testDtoToEntity()
    {
        HopArrival hopArrival = new HopArrival();
        hopArrival.setCode("Code 8899");
        hopArrival.setDateTime(OffsetDateTime.now());
        hopArrival.setDescription("Description 5566");

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        Assertions.assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        Assertions.assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
        Assertions.assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
    }

    @Test
    void testEntityToDal()
    {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("Code 8899");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        hopArrivalEntity.setDescription("Description 5566");

        HopArrivalModelEntity hopArrivalModelEntity = HopArrivalMapper.INSTANCE.entityToDal(hopArrivalEntity);

        Assertions.assertEquals(hopArrivalEntity.getCode(), hopArrivalModelEntity.getCode());
        Assertions.assertEquals(hopArrivalEntity.getDateTime(), hopArrivalModelEntity.getDateTime());
        Assertions.assertEquals(hopArrivalEntity.getDescription(), hopArrivalModelEntity.getDescription());
    }

    @Test
    void testDalToEntity()
    {
        HopArrivalModelEntity hopArrivalModelEntity = new HopArrivalModelEntity();
        hopArrivalModelEntity.setCode("Code 8899");
        hopArrivalModelEntity.setDateTime(OffsetDateTime.now());
        hopArrivalModelEntity.setDescription("Description 5566");

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dalToEntity(hopArrivalModelEntity);

        Assertions.assertEquals(hopArrivalEntity.getCode(), hopArrivalModelEntity.getCode());
        Assertions.assertEquals(hopArrivalEntity.getDateTime(), hopArrivalModelEntity.getDateTime());
        Assertions.assertEquals(hopArrivalEntity.getDescription(), hopArrivalModelEntity.getDescription());
    }

}