package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.GeoCoordinateModelEntity;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoCoordinateMapperTest
{
    @Test
    void testEntityToDal()
    {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(123.555);
        geoCoordinateEntity.setLon(33.88);

        GeoCoordinateModelEntity geoCoordinateModelEntity = GeoCoordinateMapper.INSTANCE.entityToDal(geoCoordinateEntity);

        Assertions.assertEquals(geoCoordinateModelEntity.getLat(), geoCoordinateEntity.getLat());
        Assertions.assertEquals(geoCoordinateModelEntity.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    void testDalToEntity()
    {
        GeoCoordinateModelEntity geoCoordinateModelEntity = new GeoCoordinateModelEntity();
        geoCoordinateModelEntity.setLat(22.12);
        geoCoordinateModelEntity.setLon(888.555);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dalToEntity(geoCoordinateModelEntity);

        Assertions.assertEquals(geoCoordinateEntity.getLat(), geoCoordinateModelEntity.getLat());
        Assertions.assertEquals(geoCoordinateEntity.getLon(), geoCoordinateModelEntity.getLon());
    }

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