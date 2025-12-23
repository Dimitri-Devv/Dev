package fr.dawan.formationtdd;

public class LeapYear {
    public boolean bissextile(int annee) {

        return (annee % 4 ==0 && annee % 100 !=0) || annee%400==0;

    }
}
