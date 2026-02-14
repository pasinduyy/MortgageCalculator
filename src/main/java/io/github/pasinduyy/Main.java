package io.github.pasinduyy;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        MortgageReport.displayMortgage(principal, annualInterest, years);
        MortgageReport.displayPaymentSchedule(principal, annualInterest, years);
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short noOfPaymentsMade) {
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) -
                Math.pow(1 + monthlyInterest, noOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}