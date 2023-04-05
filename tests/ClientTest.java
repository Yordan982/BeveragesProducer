package beverageproducer.tests;

import beverageproducer.Client;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ClientTest {

    private Client client;

    @Before
    public void setClient() {
        client = new Client(BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.2));

    }

    @Test
    public void getBasicDiscount() {
        assertEquals(BigDecimal.valueOf(0.3), client.getBasicDiscount());
    }

    @Test
    public void setBasicDiscount() {
        client.setBasicDiscount(BigDecimal.valueOf(0.4));
        assertEquals(BigDecimal.valueOf(0.4), client.getBasicDiscount());
    }

    @Test
    public void getDiscountAbove10000() {
        assertEquals(BigDecimal.valueOf(0.1), client.getDiscountAbove10000());

    }

    @Test
    public void getDiscountAbove30000() {
        assertEquals(BigDecimal.valueOf(0.2), client.getDiscountAbove30000());

    }

    @Test
    public void setDiscountAbove30000() {
        client.setDiscountAbove30000(BigDecimal.valueOf(0.4));
        assertEquals(BigDecimal.valueOf(0.4), client.getDiscountAbove30000());
    }
}