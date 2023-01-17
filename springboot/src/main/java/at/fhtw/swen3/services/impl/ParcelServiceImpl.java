
package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.BLException;
import at.fhtw.swen3.services.exceptions.BLNotFoundException;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.MyValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RequiredArgsConstructor
//@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {


    private final ParcelRepository parcelRepository;
    private final MyValidator validator;
    private final RecipientRepository recipientRepository;

    //@Autowired
    //private final OpenStreetEncodingProxy encodingProxy;

    private String createTrackingId() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        // Convert the UUID to a 9-character alphanumeric string
        String trackingId = uuid.toString().replaceAll("-", "").substring(0, 9).toUpperCase();
        // Make sure the trackingId matches the pattern "^[A-Z0-9]{9}$"
        if (!trackingId.matches("^[A-Z0-9]{9}$")) {
            throw new IllegalArgumentException("The generated trackingId does not match the pattern \"^[A-Z0-9]{9}$\"");
        }
        /*
        RandomStringGenerator trackingId = new RandomStringGenerator.Builder()
                .withinRange('0', 'Z')
                .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
                .build();
         */
        return trackingId;
    }

    @Override
    public NewParcelInfo submitParcel(Parcel parcel) throws BLValidationException {
        log.info("in function submitParcel()");

        //map dto to entity
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        log.info("parcelDto mapped to parcelEntity");

        // Create a new unique Tracking ID
        String trackingId = createTrackingId();
        log.info("trackingID created: " + trackingId);
        parcelEntity.setTrackingId(trackingId);

        // Set parcel state to "Pickup"
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);
        log.info("parcel state set to Pickup");

        try {
            // Validate the parcel data
            validator.validate(parcelEntity);
            log.info("parcel validated");
        } catch (BLValidationException e) {
            log.error("The BLValidation failed: {}", e.getMessage());
            throw new BLValidationException(e, "Validation failed!");
        }
        /*
        // Get GPS coordinates for package sender/recipient
        GeoCoordinateEntity senderCoordinates = encodingProxy.encodeAddress(new Address(
                parcelEntity.getSender().getStreet(),
                parcelEntity.getSender().getPostalCode(),
                parcelEntity.getSender().getCity(),
                parcelEntity.getSender().getCountry()
        ));
        log.info("SenderCoordinates Lat: " + senderCoordinates.getLat());
        log.info("SenderCoordinates Lon: " + senderCoordinates.getLon());

        GeoCoordinateEntity recipientCoordinates = encodingProxy.encodeAddress(new Address(
                parcelEntity.getRecipient().getStreet(),
                parcelEntity.getRecipient().getPostalCode(),
                parcelEntity.getRecipient().getCity(),
                parcelEntity.getRecipient().getCountry()
        ));
        log.info("RecipientCoordinates Lat: " + recipientCoordinates.getLat());
        log.info("RecipientCoordinates Lon: " + recipientCoordinates.getLon());
        */

        // Predict future route between sender and recipient
        //List<GeoCoordinateEntity> route = predictRoute(senderCoordinates, recipientCoordinates);

        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());

        // Write data to database
        parcelRepository.save(parcelEntity);
        log.info("parcel data saved in database");

        // Return the tracking ID in the response
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId(trackingId);
        return newParcelInfo;
    }


    @Override
    public NewParcelInfo transferParcel(String trackingId, Parcel parcel) throws BLException {

        //map dto to entity
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        log.info("parcelDto mapped to parcelEntity");

        //check if trackingid already exists
        if(parcelRepository.findByTrackingId(trackingId) != null) {
            throw new BLException(null, "A parcel with the specified trackingID is already in the system.");
        }

        // Reuse the existing tracking ID
        log.info("trackingID created: " + trackingId);
        parcelEntity.setTrackingId(trackingId);

        // Set parcel state to "Transfered"
        parcelEntity.setState(TrackingInformation.StateEnum.TRANSFERRED);
        log.info("parcel state set to Transfered");

        // Validate the data
        try {
            validator.validate(parcelEntity);
        } catch (BLValidationException e) {
            log.error("The BLValidation failed: {}", e.getMessage());
            throw new BLValidationException(e, "Validation failed!");
        }
        log.info("parcel validated");


        /*
        // Get GPS coordinates for package sender/recipient
        GeoEncodingService geoEncodingService = new OpenStreetEncodingProxy();
        parcel.setSenderCoordinates(geoEncodingService.encodeAddress(parcel.getSender()));
        parcel.setRecipientCoordinates(geoEncodingService.encodeAddress(parcel.getRecipient()));
         */

        // Predict future hops
        //parcelEntity.setFutureHops(predictRoute(parcel));

        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());

        // Write data to database
        parcelRepository.save(parcelEntity);

        // Return Tracking ID
        return new NewParcelInfo().trackingId(trackingId);
    }

    @Override
    public void reportParcelDelivery(String trackingId) throws BLException {

        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        if (parcelEntity == null) {
            log.error("Parcel does not exist with this tracking ID {}", trackingId);
            throw new BLNotFoundException(null, "Parcel does not exist with this tracking ID: " + trackingId);
        }
        log.info("Parcel state:" + parcelEntity.getState());

        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);
        log.info("Parcel state after change:" + parcelEntity.getState());

        try {
            parcelRepository.setStateToDelivered(trackingId);
            log.info("Parcel state after save:" + parcelEntity.getState());
        } catch (Exception e) {
            log.error("The operation failed due to an error: {}", e.getMessage());
            throw new BLException(null, "The operation failed due to an error: " + e.getMessage());
        }

    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws BLNotFoundException {
        TrackingInformation trackingInformation = new TrackingInformation();

        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        if (parcelEntity != null) {
            trackingInformation.setState(parcelEntity.getState());
        }
        else{
            throw new BLNotFoundException(null, "Parcel does not exist with this tracking ID: " + trackingId);
        }

        return trackingInformation;
    }
}

