package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.WarehouseNextHopsModelEntity;
import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopsMapper extends BaseMapper<WarehouseNextHopsEntity, WarehouseNextHops, WarehouseNextHopsModelEntity>{

    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);
}
