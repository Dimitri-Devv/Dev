package fr.dawan.formationtdd;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Pair {

// pariteSommePair    
// _______________________________________________________
//    public String parite(int... valeurs) {
//        int somme=0;
//        for( var v :valeurs) {
//            somme+=v;
//        }
//        if(somme%2==0) {
//            return "pair";
//        }
//        return null;
//    }
//    

// pariteSommeImpair
// _______________________________________________________
//    public String parite(int... valeurs) {
////        int somme = 0;
////        for (var v : valeurs) {
////            somme += v;
////        }
//
//        int somme = Arrays.stream(valeurs).sum();
//
////        if (somme % 2 == 0) {
////            return "pair";
////        } else {
////            return "impair";
////        }
//        return somme % 2 == 0?"pair":"impair";
//    }
//    

// paritePasParametre
// _______________________________________________________
//    public String parite(int... valeurs) {
//      int somme = Arrays.stream(valeurs).sum();
//      if(valeurs.length==0) {
//          throw new InvalidParameterException();
//      }
//      return somme % 2 == 0?"pair":"impair";
//  }

//    public String parite(int... valeurs) {
//        if (valeurs.length == 0) {
//            throw new InvalidParameterException();
//        }
//        return Arrays.stream(valeurs).sum() % 2 == 0 ? "pair" : "impair";
//    }

    public String parite(int... valeurs) {
        if (valeurs.length == 0) {
            throw new InvalidParameterException();
        }
        return (Arrays.stream(valeurs).sum() & 0x1) == 0 ? "pair" : "impair";
    }

}
