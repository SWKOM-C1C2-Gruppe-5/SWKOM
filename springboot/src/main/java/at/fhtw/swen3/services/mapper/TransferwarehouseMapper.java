package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.TransferwarehouseModelEntity;
import at.fhtw.swen3.persistence.entity.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper extends BaseMapper<TransferwarehouseEntity, Transferwarehouse, TransferwarehouseModelEntity>{

    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);
}
