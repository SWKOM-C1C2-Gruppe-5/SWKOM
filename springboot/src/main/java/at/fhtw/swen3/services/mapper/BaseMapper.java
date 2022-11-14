package at.fhtw.swen3.services.mapper;

import org.mapstruct.Mapper;


public interface BaseMapper<EN, DTO> {
    DTO entityToDto(EN entity);
    EN dtoToEntity(DTO dto);
}
