package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repository;

    public void createNewParcel() {
        //TODO mappen + validieren + speichern (nach repository schicken)
    }
}
