package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper extends BaseMapper<ErrorEntity, Error>{

    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);
}
