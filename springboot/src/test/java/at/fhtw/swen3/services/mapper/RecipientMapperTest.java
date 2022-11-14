package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipientMapperTest
{
    @Test
    void testEntityToDto()
    {
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setCity("Stockerau");
        recipientEntity.setCountry("AT");
        recipientEntity.setName("Franz Müller");
        recipientEntity.setStreet("Kaktusstraße 25");
        recipientEntity.setPostalCode("A-5588");

        Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        Assertions.assertEquals(recipientEntity.getName(), recipient.getName());
        Assertions.assertEquals(recipientEntity.getCountry(), recipient.getCountry());
        Assertions.assertEquals(recipientEntity.getCity(), recipient.getCity());
        Assertions.assertEquals(recipientEntity.getStreet(), recipient.getStreet());
        Assertions.assertEquals(recipientEntity.getPostalCode(), recipient.getPostalCode());
    }

    @Test
    void testDtoToEntity()
    {
        Recipient recipient = new Recipient();
        recipient.setCity("Stockerau");
        recipient.setCountry("AT");
        recipient.setName("Franz Müller");
        recipient.setStreet("Kaktusstraße 25");
        recipient.setPostalCode("A-5588");

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        Assertions.assertEquals(recipientEntity.getName(), recipient.getName());
        Assertions.assertEquals(recipientEntity.getCountry(), recipient.getCountry());
        Assertions.assertEquals(recipientEntity.getCity(), recipient.getCity());
        Assertions.assertEquals(recipientEntity.getStreet(), recipient.getStreet());
        Assertions.assertEquals(recipientEntity.getPostalCode(), recipient.getPostalCode());
    }

}