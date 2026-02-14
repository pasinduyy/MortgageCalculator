package io.github.pasinduyy;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currencyInstance;
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void displayMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        String mortgageFormatted = currencyInstance.format(mortgage);

        System.out.println();
        System.out.println("----- MORTGAGE -----");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void displayPaymentSchedule() {
        System.out.println();
        System.out.println("----- PAYMENT SCHEDULE -----");
        for (double balance : mortgageCalculator.getRemainingBalances()) {
            System.out.println(currencyInstance.format(balance));
        }
    }
}
