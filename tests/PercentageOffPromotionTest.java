package beverageproducer.tests;

import beverageproducer.promotions.PercentageOffPromotion;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class PercentageOffPromotionTest {

    @Test
    public void applyPromotionSuccessThirtyPercent() {

        PercentageOffPromotion percentageOffPromotion = new PercentageOffPromotion(0.3);

        assertEquals(BigDecimal.valueOf(10.50),percentageOffPromotion.applyPromotion(BigDecimal.valueOf(1.50), 10).setScale(1, RoundingMode.DOWN));

    }

    @Test
    public void applyPromotionSuccessFiftyPercent() {

        PercentageOffPromotion percentageOffPromotion = new PercentageOffPromotion(0.5);

        assertEquals(BigDecimal.valueOf(7.5),percentageOffPromotion.applyPromotion(BigDecimal.valueOf(1.50), 10).setScale(1,RoundingMode.DOWN));

    }

    @Test
    public void applyPromotionSuccessZeroPercent() {

        PercentageOffPromotion percentageOffPromotion = new PercentageOffPromotion(0);

        assertEquals(BigDecimal.valueOf(15),percentageOffPromotion.applyPromotion(BigDecimal.valueOf(1.50), 10).setScale(0,RoundingMode.DOWN));

    }

    @Test
    public void applyPromotionFail() {

        PercentageOffPromotion percentageOffPromotion = new PercentageOffPromotion(0.3);

        assertNotEquals(BigDecimal.valueOf(11.0),percentageOffPromotion.applyPromotion(BigDecimal.valueOf(1.50), 12));

    }
}