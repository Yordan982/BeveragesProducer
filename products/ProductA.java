package beverageproducer.products;

import beverageproducer.MarkupType;
import beverageproducer.promotions.Promotion;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.validators.ValueValidator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductA implements BaseProduct{
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int productID;
    private static BigDecimal unitCost = BigDecimal.valueOf(0.52);
    private static BigDecimal markup = BigDecimal.valueOf(0.8);
    private static MarkupType markupType = MarkupType.PERCENTAGE;

    private Promotion promotion = null;

    public ProductA() {
        productID = ID_GENERATOR.getAndIncrement();
    }

    public static void setUnitCost(BigDecimal unitCost) throws NegativeValueException {
        ValueValidator.validateValue(unitCost);
        ProductA.unitCost = unitCost;
    }

    public static void setMarkup(BigDecimal markup) throws NegativeValueException {
        ValueValidator.validateValue(markup);
        ProductA.markup = markup;
    }

    public static void setMarkupType(MarkupType markupType) {
        ProductA.markupType = markupType;
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

    public int getProductID() {
        return productID;
    }

    public ProductA setProductID(int productID) {
        this.productID = productID;
        return this;
    }
    @Override
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public BigDecimal calculateRetailPrice(){
        if (markupType.equals(MarkupType.PERCENTAGE)) return unitCost.add(unitCost.multiply(markup));
        return unitCost.add(markup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductA)) return false;
        ProductA productA = (ProductA) o;
        return productID == productA.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
}
