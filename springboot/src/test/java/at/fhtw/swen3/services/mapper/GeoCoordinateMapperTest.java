package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.OpenStreetEncodingProxy;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exceptions.BLNotFoundException;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
@Transactional
@Slf4j
class GeoCoordinateMapperTest
{

    //@Autowired
    //private TruckRepository truckRepository;

    @Autowired
    private HopRepository hopRepository;

    @Test
    void findAllHops() {
        hopRepository.findAll();
    }

    @Test
    @Commit
    void addNewTruck() {
        Truck truck = new Truck();
        truck.setNumberPlate("MD180FW");
        truck.setRegionGeoJson("Niederösterreich");
        truck.setCode("CodeTruck");
        truck.setDescription("descriptionTruck");
        truck.setLocationName("Mödling");

        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truck);

        hopRepository.save(truckEntity);

        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId(1);
        warehouseEntity.setLevel(5);
        warehouseEntity.setCode("123456Test1");
        warehouseEntity.setDescription("BeschreibungWarehouse");

        hopRepository.save(warehouseEntity);
        hopRepository.findAll().forEach(System.out::println);
    }

    @Test
    void openStreetEncodingProxyTest() {
        Address address = new Address();
        address.setStreet("87/Aspernstraße");
        address.setPostalCode("1220");
        address.setCity("Vienna");
        address.setCountry("Austria");

        try {
            GeoCoordinateEntity geo = new OpenStreetEncodingProxy().encodeAddress(address);
            System.out.println("lat: " + geo.getLat() + ", lon: " + geo.getLon());
        } catch (BLValidationException e) {
            log.error("The operation failed due to an error: {}", e.getMessage());
        }

    }


    /*
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