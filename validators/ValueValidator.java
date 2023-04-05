package beverageproducer.validators;

import beverageproducer.exceptions.NegativeValueException;

import java.math.BigDecimal;

public class ValueValidator {

    public static void validateValue(BigDecimal value) throws NegativeValueException {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeValueException("Value must be positive.");
    }
}