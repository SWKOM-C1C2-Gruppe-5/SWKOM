package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopArrivalModelEntity;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopArrivalMapper extends BaseMapper<HopArrivalEntity, HopArrival, HopArrivalModelEntity> {

    HopArrivalMapper INSTANCE = Mappers.getMapper(HopArrivalMapper.class);

}
