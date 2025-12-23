package fr.dawan.formationtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Année bissextiles
//En appliquant le TDD, écrire une méthode qui indique Une année est bissextile
//Une année est bissextile

//si elle est divisible par 4, à l'exception des années divisibles par 100
//si elle est divisible par 400
public class LeapYearTest {

    private LeapYear leapYear;

    @BeforeEach
    public void setup() {
        leapYear = new LeapYear();
    }

    @Test
    public void anneeDivisiblePar4(){
        assertTrue((Boolean) leapYear.bissextile(2024));
    }

    @Test
    public void anneeDivisiblePar4NonPar100(){
        assertFalse((Boolean) leapYear.bissextile(1800));
    }

    @Test
    public void anneeDivisiblePar400(){
        assertTrue((Boolean) leapYear.bissextile(400));
    }
}
