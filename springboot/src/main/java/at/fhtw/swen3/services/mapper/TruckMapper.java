package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.TruckModelEntity;
import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper extends BaseMapper<TruckEntity, Truck, TruckModelEntity>{
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);
}