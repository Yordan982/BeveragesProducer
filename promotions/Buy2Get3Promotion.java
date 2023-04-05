package beverageproducer.promotions;
import java.math.BigDecimal;

public class Buy2Get3Promotion implements Promotion {

    public Buy2Get3Promotion() {
    }

    @Override
    public BigDecimal applyPromotion(BigDecimal productRetailPrice, int quantity) {
        int freeQuantity = quantity / 3;
        int newQuantity = quantity - freeQuantity;
        return BigDecimal.valueOf(newQuantity).multiply(productRetailPrice);
    }
}