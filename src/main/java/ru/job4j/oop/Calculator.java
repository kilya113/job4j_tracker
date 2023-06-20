package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return (double) y / x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sumResult = Calculator.sum(4);
        int multResult = calculator.multiply(4);
        int minusResult = Calculator.minus(4);
        double divResult = calculator.divide(4);
        double sumAllResult = calculator.sumAllOperation(4);

        System.out.println("sumResult = " + sumResult + "\n"
                + "multResult = " + multResult + "\n"
                + "minusResult = " + minusResult + "\n"
                + "divResult = " + divResult + "\n"
                + "sumAllResult = " + sumAllResult);
    }
}
