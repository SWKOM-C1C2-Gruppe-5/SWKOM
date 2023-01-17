package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.BLException;
import at.fhtw.swen3.services.exceptions.BLNotFoundException;
import at.fhtw.swen3.services.exceptions.BLValidationException;

public interface ParcelService {
    NewParcelInfo submitParcel(Parcel parcel) throws BLValidationException;

    NewParcelInfo transferParcel(String trackingId, Parcel parcel) throws BLException;

    void reportParcelDelivery(String trackingId) throws BLException;

    TrackingInformation trackParcel(String trackingId) throws BLNotFoundException;
}
