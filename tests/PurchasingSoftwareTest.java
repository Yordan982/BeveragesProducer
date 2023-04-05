package beverageproducer.tests;

import beverageproducer.Client;
import beverageproducer.PurchasingSoftware;
import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PurchasingSoftwareTest {

    Map<BaseProduct, Integer> products = new HashMap<>();
    PurchasingSoftware purchasingSoftware = new PurchasingSoftware();
    Client client = new Client(BigDecimal.valueOf(0.04), BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02));


    @Before
    public void Test_Purchasing() {
        products.put(new ProductA(), 5000);
        products.put(new ProductB(), 6000);
        products.put(new ProductC(), 4000);
        products.put(new ProductD(), 20000);
    }

    @Test
    public void calculatePriceThrowsException() {
        products.put(new ProductA(), -100);
        assertThrows(NegativeValueException.class, () -> purchasingSoftware.calculatePrice(client, products));
    }

    @Test
    public void returnProductPriceWithoutProductDiscountsSuccess() {
        assertEquals(BigDecimal.valueOf(4680.00), purchasingSoftware.returnProductPriceWithProductDiscounts(products.entrySet().iterator().next()).setScale(1, RoundingMode.DOWN));
    }

    @Test
    public void returnProductPriceWithProductDiscountsSuccess() {
        Map.Entry<BaseProduct, Integer> firstkey = products.entrySet().stream().findFirst().orElse(null);
        products.remove(firstkey.getKey());
        assertEquals(BigDecimal.valueOf(3511.2), purchasingSoftware.returnProductPriceWithProductDiscounts(products.entrySet().iterator().next()).setScale(1, RoundingMode.DOWN));
    }

    @Test
    public void calculateFinalPriceWithCustomerDiscountsBelow10000() {
        assertEquals(BigDecimal.valueOf(33374.976), purchasingSoftware.calculateFinalPriceWithCustomerDiscounts(client, BigDecimal.valueOf(34765.6), 5000));
    }

    @Test
    public void calculateFinalPriceWithCustomerDiscountsOver10000() {
        assertEquals(BigDecimal.valueOf(33041.22624), purchasingSoftware.calculateFinalPriceWithCustomerDiscounts(client, BigDecimal.valueOf(34765.6), 15000));
    }

    @Test
    public void calculateFinalPriceWithCustomerDiscountsOver30000() {
        assertEquals(BigDecimal.valueOf(32707.47648), purchasingSoftware.calculateFinalPriceWithCustomerDiscounts(client, BigDecimal.valueOf(34765.6), 35000));
    }

    @Test
    public void applyCustomerDiscount() {
        assertEquals(BigDecimal.valueOf(2880), purchasingSoftware.applyCustomerDiscount(BigDecimal.valueOf(3000), BigDecimal.valueOf(0.04)).setScale(0, RoundingMode.DOWN));

    }

    @Test
    public void applyCustomerDiscountZero() {
        assertEquals(BigDecimal.valueOf(3000), purchasingSoftware.applyCustomerDiscount(BigDecimal.valueOf(3000), BigDecimal.valueOf(0)).setScale(0, RoundingMode.DOWN));
    }

    @Test
    public void validateQuantities() {
        assertThrows(NegativeValueException.class, () -> purchasingSoftware.validateQuantities(List.of(-3, 4, 5)));
    }


}