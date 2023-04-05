package beverageproducer.promotions;

import java.math.BigDecimal;

public interface Promotion {
    BigDecimal applyPromotion(BigDecimal productRetailPrice, int quantity);
}
