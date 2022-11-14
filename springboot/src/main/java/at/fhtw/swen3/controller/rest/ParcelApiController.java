package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T12:14:07.669603Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;

    //private final ParcelServiceImpl parcelServiceImpl;

    @Autowired
    public ParcelApiController(NativeWebRequest request /*, ParcelServiceImpl parcelServiceImpl*/) {
        this.request = request;
        //this.parcelServiceImpl = parcelServiceImpl;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /*
    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        parcelServiceImpl.createNewParcel(parcel);
        return ParcelApi.super.submitParcel(parcel);
    }
    */

}
