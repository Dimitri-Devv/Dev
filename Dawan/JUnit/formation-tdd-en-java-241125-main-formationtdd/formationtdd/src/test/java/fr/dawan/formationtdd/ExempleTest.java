package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ExempleTest {

    // Exemple d'assertion de Junit

    // assertSame et assertNotSame
    // égalité de référence -> même objet
    @Test
    public void sameTest() {
        String result = Exemple.processStringLitteral();
        assertSame("azerty", result); // test reussit -> référence égale
    }

    @Test
    public void notSameTest() {
        String result = Exemple.processString();
        assertNotSame("azerty", result);
    }

    // assertArrayEquals
    // égalité de 2 tableaux
    @Test
    public void arrayTest() {
        double expected[] = { 1.2, 3.4, 5.6, 7.8 };
        assertArrayEquals(expected, Exemple.processArray());
    }

    // assertIterableEquals
    // égalité de 2 Collections (qui hérite l'interface collection)
    @Test
    void iterableTest() {
        List<Integer> expected = Arrays.asList(6, 1, 8, 3);
        assertIterableEquals(expected, Exemple.processList());
    }

    // assertTimeout
    // vérifie que la méthode s'exécute avant le délai précisé
    @Test
    void timeoutTest() {
        assertTimeout(Duration.ofMillis(400), () -> Exemple.processTime(200));
    }

    // assertTimeoutPreemptively
    // idem, mais dés que le délai est dépassé la méthode est arrété
    @Test
    void timeoutPreemptivelyTest() {
        assertTimeoutPreemptively(Duration.ofMillis(400), () -> Exemple.processTime(200));
    }

    // Nombre d'assertion par méthode
    // – tester un seul concept par méthode de test
    // - minimiser le nombre d'assertion par concept
    @Test
    public void intervalMin() {
        assertTrue(Exemple.interval(-4, -5, 8));
        assertTrue(Exemple.interval(-5, -5, 8));
        assertFalse(Exemple.interval(-6, -5, 8));
    }

    @Test
    public void intervalMax() {
        assertTrue(Exemple.interval(7, -5, 8));
        assertTrue(Exemple.interval(8, -5, 8));
        assertFalse(Exemple.interval(9, -5, 8));
    }

    // Regrouper les assertions => assertAll
    @Test
    @Disabled
    public void assertNotAll() {
        assertEquals(200, Exemple.createDimension(400, 500).getWidth());
        // La deuxième assertion n'est pas éxécuté car la première a échoué
        assertEquals(300, Exemple.createDimension(400, 500).getHeight());
    }

    // assertAll
    // permet de regrouper plusieurs assertions qui seront toutes exécutées 
    // même si une des assertions du groupe échoue
    @Test
    @Disabled
    public void assertAllTest() {
        assertAll("Dimmension non conforme", //  message afficher quand le test échoue [Optionel]
                () -> assertEquals(200, Exemple.createDimension(400, 500).getWidth()),
                () -> assertEquals(300, Exemple.createDimension(400, 500).getHeight()));

    }
}
