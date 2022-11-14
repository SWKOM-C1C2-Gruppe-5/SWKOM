package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParcelMapperTest {

    @Test
    void testEntityToDto() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setId(1);
        recipient.setName("Walter");
        recipient.setStreet("Satoschigasse 83");
        recipient.setPostalCode("1200");
        recipient.setCity("Vienna");
        recipient.setCountry("Austria");

        RecipientEntity sender = new RecipientEntity();
        sender.setId(1);
        sender.setName("Walruss");
        sender.setStreet("Satoschigasse 84");
        sender.setPostalCode("1210");
        sender.setCity("Vienna");
        sender.setCountry("Austria");

        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setId(1);
        parcelEntity.setWeight(50F);
        parcelEntity.setRecipient(recipient);
        parcelEntity.setSender(sender);
        Parcel parcel = ParcelMapper.INSTANCE.entityToDto(parcelEntity);

        // Parcel Weight
        Assertions.assertEquals(parcel.getWeight(), parcelEntity.getWeight());
        // Recipient
        Assertions.assertEquals(parcel.getRecipient().getName(), parcelEntity.getRecipient().getName());
        Assertions.assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        Assertions.assertEquals(parcel.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        Assertions.assertEquals(parcel.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        Assertions.assertEquals(parcel.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        //Sender
        Assertions.assertEquals(parcel.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
        Assertions.assertEquals(parcel.getSender().getName(), parcelEntity.getSender().getName());
        Assertions.assertEquals(parcel.getSender().getStreet(), parcelEntity.getSender().getStreet());
        Assertions.assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        Assertions.assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
    }

    @Test
    void testDtoToEntity() {
        Recipient recipient = new Recipient();
        recipient.setName("Walter");
        recipient.setStreet("Satoschigasse 83");
        recipient.setPostalCode("1200");
        recipient.setCity("Vienna");
        recipient.setCountry("Austria");

        Recipient sender = new Recipient();
        sender.setName("Walruss");
        sender.setStreet("Satoschigasse 84");
        sender.setPostalCode("1210");
        sender.setCity("Vienna");
        sender.setCountry("Austria");

        Parcel parcel = new Parcel();
        parcel.setWeight(50F);
        parcel.setRecipient(recipient);
        parcel.setSender(sender);

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);

        // Parcel Weight
        Assertions.assertEquals(parcel.getWeight(), parcelEntity.getWeight());
        // Recipient
        Assertions.assertEquals(parcel.getRecipient().getName(), parcelEntity.getRecipient().getName());
        Assertions.assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        Assertions.assertEquals(parcel.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        Assertions.assertEquals(parcel.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        Assertions.assertEquals(parcel.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        //Sender
        Assertions.assertEquals(parcel.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
        Assertions.assertEquals(parcel.getSender().getName(), parcelEntity.getSender().getName());
        Assertions.assertEquals(parcel.getSender().getStreet(), parcelEntity.getSender().getStreet());
        Assertions.assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        Assertions.assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
    }

}
