package beverageproducer.promotions;
import java.math.BigDecimal;

public class PercentageOffPromotion implements Promotion{

    double percent;

    public PercentageOffPromotion(double percent) {
        this.percent = percent;
    }

    @Override
    public BigDecimal applyPromotion(BigDecimal productRetailPrice, int quantity) {
        return BigDecimal.valueOf(quantity).multiply(productRetailPrice).multiply(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(percent)));
    }
}