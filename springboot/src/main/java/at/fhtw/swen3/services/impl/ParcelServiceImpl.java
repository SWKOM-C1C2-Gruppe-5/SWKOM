
package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.MyValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {
/*
    private final ParcelRepository parcelRepository;

    @Autowired
    private ParcelMapper parcelMapper;

    @Autowired
    private MyValidator parcelValidator;

    public void createNewParcel(Parcel parcel) {

        //1. map dto to entity
        ParcelEntity parcelEntity = parcelMapper.dtoToEntity(parcel);
        log.info("parcelDto mapped to parcelEntity");

        //2. validate entity
        parcelValidator.validate(parcelEntity);
        log.info("parcelEntity validated");

        //3. save entity
        parcelRepository.save(parcelEntity);

        log.info("parcelEntity saved");
    }
*/
}

