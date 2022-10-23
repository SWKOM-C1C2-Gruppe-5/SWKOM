package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.RecipientModelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testEntityToDal()
    {
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setCity("Stockerau");
        recipientEntity.setCountry("AT");
        recipientEntity.setName("Franz Müller");
        recipientEntity.setStreet("Kaktusstraße 25");
        recipientEntity.setPostalCode("A-5588");

        RecipientModelEntity recipientModelEntity = RecipientMapper.INSTANCE.entityToDal(recipientEntity);

        Assertions.assertEquals(recipientEntity.getName(), recipientModelEntity.getName());
        Assertions.assertEquals(recipientEntity.getCountry(), recipientModelEntity.getCountry());
        Assertions.assertEquals(recipientEntity.getCity(), recipientModelEntity.getCity());
        Assertions.assertEquals(recipientEntity.getStreet(), recipientModelEntity.getStreet());
        Assertions.assertEquals(recipientEntity.getPostalCode(), recipientModelEntity.getPostalCode());
    }

    @Test
    void testDalToEntity()
    {
        RecipientModelEntity recipientModelEntity = new RecipientModelEntity();
        recipientModelEntity.setCity("Stockerau");
        recipientModelEntity.setCountry("AT");
        recipientModelEntity.setName("Franz Müller");
        recipientModelEntity.setStreet("Kaktusstraße 25");
        recipientModelEntity.setPostalCode("A-5588");

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dalToEntity(recipientModelEntity);

        Assertions.assertEquals(recipientEntity.getName(), recipientModelEntity.getName());
        Assertions.assertEquals(recipientEntity.getCountry(), recipientModelEntity.getCountry());
        Assertions.assertEquals(recipientEntity.getCity(), recipientModelEntity.getCity());
        Assertions.assertEquals(recipientEntity.getStreet(), recipientModelEntity.getStreet());
        Assertions.assertEquals(recipientEntity.getPostalCode(), recipientModelEntity.getPostalCode());
    }

}