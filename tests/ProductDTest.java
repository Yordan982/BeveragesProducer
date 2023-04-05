package beverageproducer.tests;

import beverageproducer.MarkupType;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.ProductD;
import beverageproducer.promotions.Buy2Get3Promotion;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductDTest {

    ProductD productD = new ProductD();

    @Test
    public void setUnitCost() throws NegativeValueException {
        ProductD.setUnitCost(BigDecimal.valueOf(0.3));
        assertEquals(BigDecimal.valueOf(0.3), productD.getUnitCost());
    }

    @Test
    public void setUnitCostError() {
        assertThrows(NegativeValueException.class, () -> ProductD.setUnitCost(BigDecimal.valueOf(-0.7)));
    }

    @Test
    public void setMarkupError() {
        assertThrows(NegativeValueException.class, () -> ProductD.setMarkup(BigDecimal.valueOf(-0.7)));

    }

    @Test
    public void getPromotion() {
        assertTrue(productD.getPromotion() instanceof Buy2Get3Promotion);
    }

    @Test
    public void setPromotion() {
        productD.setPromotion(new Buy2Get3Promotion());
        assertTrue(productD.getPromotion() instanceof Buy2Get3Promotion);
    }

    @Test
    public void setMarkup() throws NegativeValueException {
        ProductD.setMarkup(BigDecimal.valueOf(0.5));
        assertEquals(BigDecimal.valueOf(0.5), productD.getMarkup());
    }

    @Test
    public void getMarkup() {
        assertEquals(BigDecimal.valueOf(0.5), productD.getMarkup());
    }

    @Test
    public void getMarkupType() {
        assertEquals(MarkupType.VALUE, productD.getMarkupType());
    }

}