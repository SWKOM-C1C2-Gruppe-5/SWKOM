package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopModelEntity;
import at.fhtw.swen3.persistence.entity.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper extends BaseMapper<HopEntity, Hop, HopModelEntity>{

    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);
}
