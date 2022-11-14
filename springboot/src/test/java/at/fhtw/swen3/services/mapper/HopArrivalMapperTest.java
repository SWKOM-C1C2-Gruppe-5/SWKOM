package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

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

}