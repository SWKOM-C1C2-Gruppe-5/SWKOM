package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TruckMapperTest
{
    @Test
    void testDtoToEntity()
    {
        Truck truck = new Truck();
        truck.setNumberPlate("MD180FW");
        truck.setRegionGeoJson("Niederösterreich");
        truck.setCode("CodeTruck");
        truck.setDescription("descriptionTruck");
        truck.setLocationName("Mödling");

        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truck);

        Assertions.assertEquals(truckEntity.getNumberPlate(), truck.getNumberPlate());
        Assertions.assertEquals(truckEntity.getRegionGeoJson(), truck.getRegionGeoJson());
        Assertions.assertEquals(truckEntity.getCode(), truck.getCode());
        Assertions.assertEquals(truckEntity.getDescription(), truck.getDescription());
        Assertions.assertEquals(truckEntity.getLocationName(), truck.getLocationName());
    }

    @Test
    void testEntityToDto()
    {
        TruckEntity truckEntity = new TruckEntity();
        truckEntity.setNumberPlate("MD180FW");
        truckEntity.setRegionGeoJson("Niederösterreich");
        truckEntity.setCode("CodeTruck");
        truckEntity.setDescription("descriptionTruck");
        truckEntity.setLocationName("Mödling");

        Truck truck = TruckMapper.INSTANCE.entityToDto(truckEntity);

        Assertions.assertEquals(truckEntity.getNumberPlate(), truck.getNumberPlate());
        Assertions.assertEquals(truckEntity.getRegionGeoJson(), truck.getRegionGeoJson());
        Assertions.assertEquals(truckEntity.getCode(), truck.getCode());
        Assertions.assertEquals(truckEntity.getDescription(), truck.getDescription());
        Assertions.assertEquals(truckEntity.getLocationName(), truck.getLocationName());
    }

}