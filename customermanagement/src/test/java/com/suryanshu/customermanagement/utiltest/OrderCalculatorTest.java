package com.suryanshu.customermanagement.utiltest;

import com.suryanshu.customermanagement.util.OrderCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderCalculatorTest {

    @Test
    void testCalculateTotalAmount() {
        Map<String, Double> items = new HashMap<>();
        items.put("item1", 10.0);
        items.put("item2", 15.0);
        items.put("item3", 20.0);

        Map<String, Integer> quantities = new HashMap<>();
        quantities.put("item1", 2);
        quantities.put("item2", 3);

        double totalAmount = OrderCalculator.calculateTotalAmount(items, quantities);

        assertEquals(2 * 10.0 + 3 * 15.0, totalAmount);
    }

    @Test
    void testCalculateTotalAmountWithDiscount() {
        Map<String, Double> items = new HashMap<>();
        items.put("item1", 10.0);
        items.put("item2", 15.0);
        items.put("item3", 20.0);

        Map<String, Integer> quantities = new HashMap<>();
        quantities.put("item1", 2);
        quantities.put("item2", 3);

        double discountPercentage = 10.0;

        double finalAmount = OrderCalculator.calculateTotalAmountWithDiscount(items, quantities, discountPercentage);

        double expectedAmountWithoutDiscount = OrderCalculator.calculateTotalAmount(items, quantities);
        double expectedFinalAmount = expectedAmountWithoutDiscount * (1 - discountPercentage / 100);

        assertEquals(expectedFinalAmount, finalAmount);
    }
}

