package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.WarehouseModelEntity;
import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper extends BaseMapper<WarehouseEntity, Warehouse, WarehouseModelEntity>{

    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
}
