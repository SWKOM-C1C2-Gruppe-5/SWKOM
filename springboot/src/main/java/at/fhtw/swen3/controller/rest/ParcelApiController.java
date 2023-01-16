package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.exceptions.BLNotFoundException;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import at.fhtw.swen3.services.impl.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T12:14:07.669603Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;


    private final ParcelService parcelService;


    public ParcelApiController(NativeWebRequest request , ParcelService parcelService) {
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        try {
            try {
                NewParcelInfo newParcelInfo = parcelService.submitParcel(parcel);
                log.info("submitParcel() function called");
                return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.CREATED);
            } catch (BLValidationException e) {
                log.error("The BLValidation failed: {}", e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("The operation failed due to an error: {}", e.getMessage());
            return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        NewParcelInfo newParcelInfo = parcelService.transferParcel(trackingId, parcel);
        return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.OK);
    }

}
