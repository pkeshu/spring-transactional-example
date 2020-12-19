package com.keshar.transactionaldemo.util;

import com.keshar.transactionaldemo.exception.InvalidAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtil {
    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.00);
        paymentMap.put("acc2", 10000.00);
        paymentMap.put("acc3", 5000.00);
        paymentMap.put("acc4", 8000.00);
    }

    public static boolean validateCreditLimit(String accountNumber, double paidAmount) {
        if (paidAmount >= paymentMap.get(accountNumber)) {
            throw new InvalidAmountException("Insufficient Amount..!");
        } else
            return true;
    }
}
