package com.suryanshu.customermanagement.util;

import java.util.HashMap;
import java.util.Map;

public class OrderCalculator {

    public static double calculateTotalAmountWithDiscount(Map<String, Double> items, Map<String, Integer> quantities, double discountPercentage) {
        double totalAmount = calculateTotalAmount(items, quantities);
        double discountedAmount = applyDiscount(totalAmount, discountPercentage);
        return discountedAmount;
    }

    public static double calculateTotalAmount(Map<String, Double> items, Map<String, Integer> quantities) {
        double totalAmount = 0.0;
        for (String item : items.keySet()) {
            if (quantities.containsKey(item)) {
                totalAmount += items.get(item) * quantities.get(item);
            }
        }
        return totalAmount;
    }

    private static double applyDiscount(double totalAmount, double discountPercentage) {
        double discount = (discountPercentage / 100) * totalAmount;
        return totalAmount - discount;
    }

    public static void main(String[] args) {
        // Example items with prices
        Map<String, Double> items = new HashMap<>();
        items.put("item1", 10.0);
        items.put("item2", 15.0);
        items.put("item3", 20.0);

        // Example quantities
        Map<String, Integer> quantities = new HashMap<>();
        quantities.put("item1", 2);
        quantities.put("item2", 3);

        double discountPercentage = 10.0; // Example discount percentage

        double amountWithoutDiscount=calculateTotalAmount(items,quantities);
        System.out.println("Total amount without discount : Rs."+amountWithoutDiscount);

        double finalAmount = calculateTotalAmountWithDiscount(items, quantities, discountPercentage);
        System.out.println("Final Total Amount after applying discount: Rs." + finalAmount);
    }
}

