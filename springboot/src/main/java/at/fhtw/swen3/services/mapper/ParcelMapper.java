package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopArrivalModelEntity;
import at.fhtw.swen3.model.entities.ParcelModelEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper extends BaseMapper<ParcelEntity, Parcel, ParcelModelEntity> {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

}
