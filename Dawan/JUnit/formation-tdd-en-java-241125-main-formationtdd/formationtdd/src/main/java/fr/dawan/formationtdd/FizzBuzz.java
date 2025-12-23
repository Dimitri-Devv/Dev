package fr.dawan.formationtdd;

public class FizzBuzz {

//    public String convert(int valeur) {
//        if (valeur % 15 == 0) {
//            return "FizzBuzz";
//        }
//        if (valeur % 3 == 0) {
//            return "Fizz";
//        }
//        if (valeur % 5 == 0) {
//            return "Buzz";
//        }
//        return String.valueOf(valeur);
//    }

// Modification des règles
//    public String convert(int valeur) {
//        String nombreStr = String.valueOf(valeur);
//        if (valeur % 15 == 0 || (nombreStr.contains("3") && nombreStr.contains("5"))) {
//            return "FizzBuzz";
//        }
//        if (valeur % 3 == 0 || nombreStr.contains("3")) {
//            return "Fizz";
//        }
//        if (valeur % 5 == 0 || nombreStr.contains("5")) {
//            return "Buzz";
//        }
//        return nombreStr;
//    }

    public String convert(int valeur) {
        String nombreStr = String.valueOf(valeur);
        StringBuilder nombre = new StringBuilder(8);
        if (valeur % 3 == 0 || nombreStr.contains("3")) {
            nombre.append("Fizz");
        }
        if (valeur % 5 == 0 || nombreStr.contains("5")) {
            nombre.append("Buzz");
        }
        return nombre.isEmpty() ? nombreStr : nombre.toString();
    }

}
