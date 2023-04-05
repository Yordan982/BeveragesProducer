package beverageproducer.products;

import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.promotions.Buy2Get3Promotion;
import beverageproducer.MarkupType;
import beverageproducer.promotions.Promotion;
import beverageproducer.validators.ValueValidator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductD implements BaseProduct{
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int productID;
    private static BigDecimal unitCost = BigDecimal.valueOf(0.6);
    private static BigDecimal markup = BigDecimal.valueOf(1);
    private static MarkupType markupType = MarkupType.VALUE;
    private Promotion promotion = new Buy2Get3Promotion();

    public ProductD() {
        productID = ID_GENERATOR.getAndIncrement();

    }

    public static void setUnitCost(BigDecimal unitCost) throws NegativeValueException {
        ValueValidator.validateValue(unitCost);
        ProductD.unitCost = unitCost;
    }

    public static void setMarkup(BigDecimal markup) throws NegativeValueException {
        ValueValidator.validateValue(markup);
        ProductD.markup = markup;
    }

    public static void setMarkupType(MarkupType markupType) {
        ProductD.markupType = markupType;
    }

    @Override
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    @Override
    public BigDecimal getMarkup() {
        return markup;
    }

    @Override
    public MarkupType getMarkupType() {
        return markupType;
    }

    @Override
    public BigDecimal calculateRetailPrice(){
        if (markupType.equals(MarkupType.PERCENTAGE)) return unitCost.add(unitCost.multiply(markup));
        return unitCost.add(markup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductD)) return false;
        ProductD productD = (ProductD) o;
        return productID == productD.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
}
