package at.fhtw.swen3;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.ParcelMapper;
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

        Assertions.assertEquals(parcel.getWeight(), parcelEntity.getWeight());
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

        Assertions.assertEquals(parcel.getWeight(), parcelEntity.getWeight());

    }
}
