package fr.dawan.formationtdd;

public class Calcul {

    private final static double eps = 1e-15;

    public static int addition(int a, int b) {
        return a + b;
    }

    public double division(double n, double d) {
        if (d > -eps && d < eps) { // correspond à d==0.0
            throw new ArithmeticException("Division par 0");
        }
        return n / d;
    }
}
