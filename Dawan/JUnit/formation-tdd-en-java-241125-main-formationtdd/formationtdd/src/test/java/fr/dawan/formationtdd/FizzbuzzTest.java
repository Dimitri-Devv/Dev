package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// ## FizzBuzz
// On affiche une suite de nombre de 1 à 100 est
// - quand le nombre est divisible par 3, on remplace le nombre par Fizz
// - quand le nombre est divisible par 5, on remplace le nombre par Buzz
//
// Ecrire un classe Fizzbuzz avec une méthode convert qui prend en paramètre un entier et retourne une chaine de caractère
// public String convert(int value)
//
// En appliquent le TDD,écrire le test et ensuite être le code correspondant
// 1. pour un nombre qui n'est pas modifier
// 2. Pour un nombre multiple de 3
// 3. Pour un nombre multiple de 5
// 4. Pour un nombre multiple de 5 et de 3
//
// ### On modifie la règle:
// - un nombre est Fizz, s'il est divisible par 3 ou s'il contient 3
// - un nombre est Buzz, s'il est divisible par 5 ou s'il contient 5

public class FizzbuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void nombreNonModifie() {
        assertEquals("4", fizzBuzz.convert(4));
    }

    @Test
    public void nombreDivisiblePar3() {
        assertEquals("Fizz", fizzBuzz.convert(9));
    }

    @Test
    public void nombreDivisiblePar5() {
        assertEquals("Buzz", fizzBuzz.convert(10));
    }

    @Test
    public void nombreDivisiblePar3et5() {
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
    }

    // Modification des règles
    @Test
    public void nombreContient3() {
        assertEquals("Fizz", fizzBuzz.convert(13));
    }

    @Test
    public void nombreContient5() {
        assertEquals("Buzz", fizzBuzz.convert(52));
    }

    @Test
    public void nombreContient5et3() {
        assertEquals("FizzBuzz", fizzBuzz.convert(53));
    }
}
