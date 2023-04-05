package beverageproducer.products;

import beverageproducer.MarkupType;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.promotions.PercentageOffPromotion;
import beverageproducer.promotions.Promotion;
import beverageproducer.validators.ValueValidator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductB implements BaseProduct{
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int productID;
    private static BigDecimal unitCost = BigDecimal.valueOf(0.38);
    private static BigDecimal markup = BigDecimal.valueOf(1.2);
    private static MarkupType markupType = MarkupType.PERCENTAGE;
    private Promotion promotion = new PercentageOffPromotion(0.3);


    public ProductB() {
        productID = ID_GENERATOR.getAndIncrement();
    }

    public static void setUnitCost(BigDecimal unitCost) throws NegativeValueException {
        ValueValidator.validateValue(unitCost);
        ProductB.unitCost = unitCost;
    }

    public static void setMarkup(BigDecimal markup) throws NegativeValueException {
        ValueValidator.validateValue(markup);
        ProductB.markup = markup;
    }

    public static void setMarkupType(MarkupType markupType) {
        ProductB.markupType = markupType;
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
        if (!(o instanceof ProductB)) return false;
        ProductB productB = (ProductB) o;
        return productID == productB.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
}
