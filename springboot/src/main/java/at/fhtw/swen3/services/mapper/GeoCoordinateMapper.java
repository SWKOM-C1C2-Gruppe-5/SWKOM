package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.GeoCoordinateModelEntity;
import at.fhtw.swen3.model.entities.HopArrivalModelEntity;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper extends BaseMapper<GeoCoordinateEntity, GeoCoordinate, GeoCoordinateModelEntity> {

    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);
}
