package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;
import javax.xml.bind.ValidationException;

@Slf4j
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T12:14:07.669603Z[Etc/UTC]")
@Controller
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;


    private WarehouseService warehouseService;


    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Hop> getWarehouse(String code) {
        try {
            //warehouseService.getWarehouse(code);
            return new ResponseEntity<Hop>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("The operation failed due to an error: {}", e.getMessage());
            return new ResponseEntity<Hop>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) {
        try {
            warehouseService.importWarehouses(warehouse);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while importing warehouses: {}", e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
