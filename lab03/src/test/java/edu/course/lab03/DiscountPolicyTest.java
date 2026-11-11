package edu.course.lab03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountPolicyTest {
    @Test
    void noDiscountShouldReturnOriginalPrice() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0));
    }

    @Test
    void percentDiscountShouldReducePrice() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertEquals(80.0, policy.apply(100.0));
    }

    @Test
    void calculatorShouldAllowReplacingPolicy() {
        PriceCalculator calculatorWithoutDiscount =
                new PriceCalculator(new NoDiscount());

        PriceCalculator calculatorWithDiscount =
                new PriceCalculator(new PercentDiscount(20));

        assertEquals(100.0, calculatorWithoutDiscount.calculate(100.0));
        assertEquals(80.0, calculatorWithDiscount.calculate(100.0));
    }

    @Test
    void negativePriceShouldThrowException() {
        DiscountPolicy policy = new NoDiscount();
        assertThrows(
                IllegalArgumentException.class,
                () -> policy.apply(-100.0)
        );
    }

    @Test
    void invalidPercentShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PercentDiscount(120)
        );
    }
}
