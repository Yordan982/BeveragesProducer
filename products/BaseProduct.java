package beverageproducer.products;

import beverageproducer.MarkupType;
import beverageproducer.promotions.Promotion;

import java.math.BigDecimal;

public interface BaseProduct {

    BigDecimal getUnitCost();

    BigDecimal getMarkup();

    MarkupType getMarkupType();

    BigDecimal calculateRetailPrice();

    Promotion getPromotion();
}