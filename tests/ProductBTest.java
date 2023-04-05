package beverageproducer.tests;

import beverageproducer.MarkupType;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.ProductB;
import beverageproducer.promotions.Buy2Get3Promotion;
import beverageproducer.promotions.PercentageOffPromotion;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductBTest {

    ProductB productB = new ProductB();

    @Test
    public void setUnitCost() throws NegativeValueException {
        ProductB.setUnitCost(BigDecimal.valueOf(0.9));
        assertEquals(BigDecimal.valueOf(0.9), productB.getUnitCost());
    }

    @Test
    public void setUnitCostError() {
        assertThrows(NegativeValueException.class, () -> ProductB.setUnitCost(BigDecimal.valueOf(-0.4)));
    }

    @Test
    public void setMarkupError() {
        assertThrows(NegativeValueException.class, () -> ProductB.setMarkup(BigDecimal.valueOf(-2.4)));

    }

    @Test
    public void getPromotion() {
        assertTrue(productB.getPromotion() instanceof PercentageOffPromotion);
    }

    @Test
    public void setPromotion() {
        productB.setPromotion(new Buy2Get3Promotion());
        assertTrue(productB.getPromotion() instanceof Buy2Get3Promotion);
    }

    @Test
    public void setMarkup() throws NegativeValueException {
        ProductB.setMarkup(BigDecimal.valueOf(0.3));
        assertEquals(BigDecimal.valueOf(0.3), productB.getMarkup());
    }

    @Test
    public void getMarkup() {
        assertEquals(BigDecimal.valueOf(0.3), productB.getMarkup());
    }

    @Test
    public void getMarkupType() {
        assertEquals(MarkupType.PERCENTAGE, productB.getMarkupType());
    }

}