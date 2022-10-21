package at.fhtw.swen3.services.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper<EN, DTO, DAL> {
    DTO entityToDto(EN entity);
    EN dtoToEntity(DTO dto);

    DAL entityToDal(EN entity);
}
