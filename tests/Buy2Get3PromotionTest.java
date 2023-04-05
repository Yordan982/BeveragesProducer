package beverageproducer.tests;

import beverageproducer.promotions.Buy2Get3Promotion;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Buy2Get3PromotionTest {

    @Test
    public void applyPromotionWithRemainderSuccess() {

        Buy2Get3Promotion buy2Get3Promotion = new Buy2Get3Promotion();

        assertEquals(BigDecimal.valueOf(10.5),buy2Get3Promotion.applyPromotion(BigDecimal.valueOf(1.50), 10));

    }

    @Test
    public void applyPromotionWithoutRemainderSuccess() {

        Buy2Get3Promotion buy2Get3Promotion = new Buy2Get3Promotion();

        assertEquals(BigDecimal.valueOf(12.0),buy2Get3Promotion.applyPromotion(BigDecimal.valueOf(1.50), 12));

    }

    @Test
    public void applyPromotionFail() {

        Buy2Get3Promotion buy2Get3Promotion = new Buy2Get3Promotion();

        assertNotEquals(BigDecimal.valueOf(11.0),buy2Get3Promotion.applyPromotion(BigDecimal.valueOf(1.50), 12));

    }

}