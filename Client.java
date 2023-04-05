package beverageproducer;

import java.math.BigDecimal;

public class Client {
    private BigDecimal basicDiscount;
    private BigDecimal discountAbove10000;
    private BigDecimal discountAbove30000;

    public Client(BigDecimal basicDiscount, BigDecimal discountAbove10000, BigDecimal discountAbove30000) {
        this.basicDiscount = basicDiscount;
        this.discountAbove10000 = discountAbove10000;
        this.discountAbove30000 = discountAbove30000;
    }

    public BigDecimal getBasicDiscount() {
        return basicDiscount;
    }

    public Client setBasicDiscount(BigDecimal basicDiscount) {
        this.basicDiscount = basicDiscount;
        return this;
    }

    public BigDecimal getDiscountAbove10000() {
        return discountAbove10000;
    }

    public Client setDiscountAbove10000(BigDecimal discountAbove10000) {
        this.discountAbove10000 = discountAbove10000;
        return this;
    }

    public BigDecimal getDiscountAbove30000() {
        return discountAbove30000;
    }

    public Client setDiscountAbove30000(BigDecimal discountAbove30000) {
        this.discountAbove30000 = discountAbove30000;
        return this;
    }
}