package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeoCoordinateMapperTest
{
    /*
    @Autowired
    private TruckRepository truckRepository;

    @Test
    void findAllTrucks() {
        truckRepository.findAll();
    }
     */

    @Test
    void testEntityToDto()
    {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(22.12);
        geoCoordinateEntity.setLon(888.555);

        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        Assertions.assertEquals(geoCoordinateEntity.getLat(), geoCoordinate.getLat());
        Assertions.assertEquals(geoCoordinateEntity.getLon(), geoCoordinate.getLon());
    }

    @Test
    void testDtoToEntity()
    {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLat(22.12);
        geoCoordinate.setLon(888.555);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);

        Assertions.assertEquals(geoCoordinateEntity.getLat(), geoCoordinate.getLat());
        Assertions.assertEquals(geoCoordinateEntity.getLon(), geoCoordinate.getLon());
    }
}