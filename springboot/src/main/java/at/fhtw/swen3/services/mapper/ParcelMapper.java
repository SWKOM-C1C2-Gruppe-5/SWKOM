package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ParcelMapper extends BaseMapper<ParcelEntity, Parcel> {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

}
