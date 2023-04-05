package beverageproducer.tests;

import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.validators.ValueValidator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ValueValidatorTest {

    @Test
    public void validateValueThrowsException() {
        assertThrows(NegativeValueException.class, () -> ValueValidator.validateValue(BigDecimal.valueOf(-10)));
    }
}