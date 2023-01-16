package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.exceptions.BLValidationException;

public interface ParcelService {
    NewParcelInfo submitParcel(Parcel parcel) throws BLValidationException;

    NewParcelInfo transferParcel(String trackingId, Parcel parcel);
}
