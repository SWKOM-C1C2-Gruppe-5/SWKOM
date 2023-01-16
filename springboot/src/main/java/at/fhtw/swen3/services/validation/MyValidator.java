package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.services.exceptions.BLException;
import at.fhtw.swen3.services.exceptions.BLValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
@Slf4j
public class MyValidator {
    static ValidatorFactory getValidatorFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory;
    }

    Validator getValidator() {
        return getValidatorFactory().getValidator();
    }

    public <T> void validate(T o) throws BLValidationException {
        Validator validator = getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(o);
        violations.forEach(v -> log.error(v.getMessage()));
        if (!violations.isEmpty()) {
            for (ConstraintViolation<T> v : violations) {
                log.error(v.getMessage());
                throw new BLValidationException( null, v.getMessage());
            }
        }
    }
}
