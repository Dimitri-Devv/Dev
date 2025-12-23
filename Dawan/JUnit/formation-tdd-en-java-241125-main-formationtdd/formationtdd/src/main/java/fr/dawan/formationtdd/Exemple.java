package fr.dawan.formationtdd;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

public class Exemple {

    public static String processStringLitteral() {
        return "azerty";
    }

    public static String processString() {
        return new String("azerty");
    }

    public static double[] processArray() {
        double t[] = { 1.2, 3.4, 5.6, 7.8 };
        return t;
    }

    public static List<Integer> processList() {
        return Arrays.asList(6, 1, 8, 3);
    }

    public static void processTime(int miliseconde) {
        try {
            Thread.sleep(miliseconde);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean interval(int valeur, int min, int max) {
        return valeur >= min && valeur <= max;
    }

    public static Dimension createDimension(int width, int height) {
        return new Dimension(width, height);
    }
}
