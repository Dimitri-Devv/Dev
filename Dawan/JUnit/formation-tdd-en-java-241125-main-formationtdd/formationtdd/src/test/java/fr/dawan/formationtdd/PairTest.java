package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//## Pair ou impair
// On passe un nombre paramètre variable de type entier à une méthode et
// on veut déterminer si la somme de tous les nombres est paire ou impaire
//- La réponse est retournée sous la forme d'une chaîne (impair ou pair)
//- S'il n'y a pas de paramètre, on lance  une exception InvalidParameterException

public class PairTest {

    private Pair pair;

    @BeforeEach
    public void setup() {
        pair = new Pair();
    }

    @Test
    public void pariteSommePair() {
        String resutat = pair.parite(4, 5, 1, 2);
        assertEquals("pair", resutat);
    }

    @Test
    public void pariteSommeImpair() {
        String resultat = pair.parite(2, 1, 4);
        assertEquals("impair", resultat);
    }

    @Test
    public void paritePasParametre() {
        assertThrows(InvalidParameterException.class, () -> pair.parite());
    }
}
