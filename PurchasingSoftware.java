package beverageproducer;

import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.BaseProduct;
import beverageproducer.promotions.Promotion;
import beverageproducer.validators.ValueValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Map;

public class PurchasingSoftware {

    public PurchasingSoftware() {
    }

    public BigDecimal calculatePrice(Client client, Map<BaseProduct, Integer> productAndQuantity) throws NegativeValueException {

        validateQuantities(productAndQuantity.values());

        BigDecimal finalPrice = BigDecimal.ZERO;

        for (Map.Entry<BaseProduct, Integer> product : productAndQuantity.entrySet()) {

          finalPrice = finalPrice.add(returnProductPriceWithProductDiscounts(product));

        }

        int totalQuantities = productAndQuantity.values().stream().reduce(0, Integer::sum);
        System.out.printf("%nTotal amount (EUR) before client discounts: %.2f%n", finalPrice);

        return calculateFinalPriceWithCustomerDiscounts(client, finalPrice, totalQuantities);

    }
    public BigDecimal returnProductPriceWithProductDiscounts(Map.Entry<BaseProduct, Integer> product) {
        BigDecimal finalPrice = BigDecimal.ZERO;
        if (product.getValue() > 0) {
            StringBuilder sb = new StringBuilder();
            BigDecimal productPriceWithDiscount = BigDecimal.ZERO;
            sb.append(String.format("%s quantity: %d, Base Unit Price: %.2f", product.getKey().getClass().getSimpleName(), product.getValue(), product.getKey().calculateRetailPrice()));
            if (product.getKey().getPromotion() == null) {
                productPriceWithDiscount = product.getKey().calculateRetailPrice().multiply(BigDecimal.valueOf(product.getValue()));
                finalPrice = finalPrice.add(productPriceWithDiscount);
            } else {
                Promotion promotion = product.getKey().getPromotion();
                productPriceWithDiscount = promotion.applyPromotion(product.getKey().calculateRetailPrice(), product.getValue());
                sb.append(String.format(", Promotional Unit Price (EUR): %.2f", productPriceWithDiscount.divide(BigDecimal.valueOf(product.getValue()), RoundingMode.HALF_DOWN)));
                finalPrice = finalPrice.add(productPriceWithDiscount);
            }
            sb.append(String.format(", Total (EUR): %.2f", productPriceWithDiscount));
            System.out.println(sb);
        }
        return finalPrice;
    }


    public BigDecimal calculateFinalPriceWithCustomerDiscounts(Client client, BigDecimal finalPrice, int totalQuantities) {


        BigDecimal baseDiscount = client.getBasicDiscount().multiply(finalPrice);
        System.out.printf("Basic client discount (EUR): %.2f%n", baseDiscount);
        finalPrice = finalPrice.subtract(baseDiscount);


        if (totalQuantities >= 10000 && totalQuantities < 30000) {
           finalPrice = applyCustomerDiscount(finalPrice, client.getDiscountAbove10000());
        }

        if (totalQuantities >= 30000) {
            finalPrice = applyCustomerDiscount(finalPrice, client.getDiscountAbove30000());
        }
        return finalPrice;
    }
    public BigDecimal applyCustomerDiscount(BigDecimal finalPrice, BigDecimal discount) {
        if (discount.compareTo(BigDecimal.ZERO) > 0){
            discount = discount.multiply(finalPrice);
            BigDecimal priceBeforeDiscount = finalPrice;
            finalPrice = finalPrice.subtract(discount);
            System.out.printf("Quantity discount (EUR): %.2f%n", priceBeforeDiscount.subtract(finalPrice));
        }
        return finalPrice;
    }

    public void validateQuantities(Collection<Integer> values) throws NegativeValueException {
        for (Integer value : values) {
            ValueValidator.validateValue(BigDecimal.valueOf(value));
        }

    }
}