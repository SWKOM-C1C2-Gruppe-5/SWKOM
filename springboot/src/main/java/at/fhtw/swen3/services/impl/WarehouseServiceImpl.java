
package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.MyValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    private final MyValidator validator;

    @Override
    public void importWarehouses(Warehouse warehouse) {
        try {
            validator.validate(warehouse);
        } catch (BLValidationException e) {
            log.error("The BLValidation failed: {}", e.getMessage());
        }

        //clear the existing DB
        warehouseRepository.deleteAll();
        //convert the DTO to entity
        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
        //save to the DB
        warehouseRepository.save(warehouseEntity);
    }

}
