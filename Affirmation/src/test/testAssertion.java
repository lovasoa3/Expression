import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionTest {

    @Test
    public void testEvaluer() {
        Affirmation louEstBeau = new Affirmation("Lou est beau.", Statut.VERITE);
        Affirmation louEstPauvre = new Affirmation("Lou est pauvre.", Statut.MENSONGE);
        Affirmation louEstGenereux = new Affirmation("Lou est généreux.", Statut.AFFIRMATION);

        Assertion assertion = new Assertion(louEstBeau, Conjonction.ET, louEstPauvre);

        assertEquals("faux", assertion.evaluer());
    }
}
