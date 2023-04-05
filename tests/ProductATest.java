package beverageproducer.tests;

import beverageproducer.MarkupType;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.ProductA;
import beverageproducer.promotions.Buy2Get3Promotion;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class ProductATest {
    ProductA productA = new ProductA();

    @Test
    public void setUnitCost() throws NegativeValueException {
        ProductA.setUnitCost(BigDecimal.valueOf(0.7));
        assertEquals(BigDecimal.valueOf(0.7), productA.getUnitCost());
    }

    @Test
    public void setUnitCostError() {
        assertThrows(NegativeValueException.class, () -> ProductA.setUnitCost(BigDecimal.valueOf(-2.5)));
    }

    @Test
    public void setMarkupError() {
        assertThrows(NegativeValueException.class, () -> ProductA.setMarkup(BigDecimal.valueOf(-1.3)));

    }

    @Test
    public void getPromotion() {
        assertNull(productA.getPromotion());
    }

    @Test
    public void setPromotion() {
        productA.setPromotion(new Buy2Get3Promotion());
        assertTrue(productA.getPromotion() instanceof Buy2Get3Promotion);
    }

    @Test
    public void setMarkup() throws NegativeValueException {
        ProductA.setMarkup(BigDecimal.valueOf(0.65));
        assertEquals(BigDecimal.valueOf(0.65), productA.getMarkup());
    }

    @Test
    public void getMarkup() {
        assertEquals(BigDecimal.valueOf(0.65), productA.getMarkup());
    }

    @Test
    public void getMarkupType() {
        assertEquals(MarkupType.PERCENTAGE, productA.getMarkupType());
    }
}