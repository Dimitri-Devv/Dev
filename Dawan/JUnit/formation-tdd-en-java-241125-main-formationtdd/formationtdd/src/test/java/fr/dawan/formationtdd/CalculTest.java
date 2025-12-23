package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// @DisplayName pour renommer la classe contenant les méthodes de test
@DisplayName("Test de la classe Calcul")
// @Disabled // @Disabled sur la classe => Pour désactiver tous les tests de la classe
public class CalculTest {

    private Calcul calcul;

    // Setup
    @BeforeAll
    public static void init() {
        System.out.println("@BeforeAll-> executer une fois avant toutes les classe de test");
    }

    @BeforeEach
    public void setup() {
        System.out.println("@BeforeEach-> executer avant chaque cas de test");
        calcul = new Calcul();
    }

    // -> teardown
    @AfterEach
    public void teardown() {
        System.out.println("@AfterEach -> executer après chaque cas de test");
    }

    @AfterAll
    public static void clean() {
        System.out.println("@AfterAll-> executer une fois après toutes les méthodes de la  classe de test");
    }

    @Test
    @Disabled // @Disabled sur une méthode => désactiver un test
    void emptyTest() { // La méthode n'a pas besoin d'être publique, elle peut avoir une visibilité de package
        // test sans assertion -> toujours réussi
    }

    @Test // @Test=> permet de définir la méthode comme un cas de test
    @DisplayName("Test de la méthode addition") // @DisplayName => permet de renommer le test, sinon le test a pour nom, le nom de la méthode
    public void additionTest() {
        // Exercice
        int resultat = Calcul.addition(2, 3);
        // Verify
        assertEquals(5, resultat);
        // Les assertions permettent de faire des vérifications, si elle échoue le test échoue
        // Dans les assertions:
        // - le premier paramètre est la valeur attendu
        // - le 2ème paramètre est la valeur retournée par la méthode à tester
    }

    @Test
    public void divisionTest() {
        double resultat = calcul.division(10.0, 5.0);
        assertEquals(2.0, resultat);

        // - delta -> pour les double et les float pour prendre en compte les erreurs de calcul
        // assertEquals(1.999999,0.1,resultat); // -> OK

        // - Toutes les assertions de junit peuvent avoir un troisième paramètre qui est un message afficher quand le test échoue
        assertEquals(4.0, resultat, "La division à échoué");
    }

    @Test
    public void divisionFail() {
        assertNotEquals(4.0, calcul.division(6.0, 2.0));

    }

    @Test
    public void divisionParZero() {
        // => assertThrows permet de verifier que la méthode lance une exception
        // - Le premier paramètre est l'exception attendue
        // - Le 2ème paramètre est une expression lambda qui permet d'executer la méthode à tester
        assertThrows(ArithmeticException.class, () -> calcul.division(1.0, 0.0));
        
        // Il est possible de préciser une super-classe de l'exception attendue
        // assertThrows(Exception.class, () -> calcul.division(1.0,0.0) );

        // avec JUnit 4
//        try {
//            calcul.division(1.0,0.0);
//            fail();
//        }
//        catch(ArithmeticException e) {
//            assertTrue(true);
//        }
    }

}
