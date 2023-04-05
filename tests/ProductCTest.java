package beverageproducer.tests;

import beverageproducer.MarkupType;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.ProductC;
import beverageproducer.promotions.Buy2Get3Promotion;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductCTest {

    ProductC productC = new ProductC();

    @Test
    public void setUnitCost() throws NegativeValueException {
        ProductC.setUnitCost(BigDecimal.valueOf(0.5));
        assertEquals(BigDecimal.valueOf(0.5), productC.getUnitCost());
    }

    @Test
    public void setUnitCostError() {
        assertThrows(NegativeValueException.class, ()-> ProductC.setUnitCost(BigDecimal.valueOf(-0.5)));
    }

    @Test
    public void setMarkupError() {
        assertThrows(NegativeValueException.class, ()-> ProductC.setMarkup(BigDecimal.valueOf(-0.5)));

    }

    @Test
    public void getPromotion() {
        assertNull(productC.getPromotion());
    }

    @Test
    public void setPromotion() {
        productC.setPromotion(new Buy2Get3Promotion());
        assertTrue(productC.getPromotion() instanceof  Buy2Get3Promotion);
    }

    @Test
    public void setMarkup() throws NegativeValueException {
        ProductC.setMarkup(BigDecimal.valueOf(0.6));
        assertEquals(BigDecimal.valueOf(0.6), productC.getMarkup());
    }

    @Test
    public void getMarkup() {
        assertEquals(BigDecimal.valueOf(0.6), productC.getMarkup());
    }

    @Test
    public void getMarkupType() {
        assertEquals(MarkupType.VALUE, productC.getMarkupType());
    }
}