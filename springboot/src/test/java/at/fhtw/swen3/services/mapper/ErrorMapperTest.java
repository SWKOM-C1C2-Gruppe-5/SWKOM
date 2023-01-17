package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMapperTest {
    @Test
    public void testErrorMapper() {
        // Create an ErrorEntity
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage("This is an error message");

        // Convert the ErrorEntity to Error
        Error error = ErrorMapper.INSTANCE.entityToDto(errorEntity);

        // Assert that the Error's errorMessage is the same as the ErrorEntity's errorMessage
        assertEquals(errorEntity.getErrorMessage(), error.getErrorMessage());

        // Convert the Error back to ErrorEntity
        ErrorEntity mappedErrorEntity = ErrorMapper.INSTANCE.dtoToEntity(error);

        // Assert that the ErrorEntity's errorMessage is the same as the original ErrorEntity's errorMessage
        assertEquals(errorEntity.getErrorMessage(), mappedErrorEntity.getErrorMessage());
    }


}