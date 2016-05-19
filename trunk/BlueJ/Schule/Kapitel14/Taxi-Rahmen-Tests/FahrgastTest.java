import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse FahrgastTest.
 *
 * @author  David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class FahrgastTest 
{
    /**
     * Konstruktor f�r die Test-Klasse FahrgastTest
     */
    public FahrgastTest()
    {
    }

    /**
     *  Setzt das Testger�st f�r den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    protected void setUp()
    {
    }

    /**
     * Gibt das Testger�st wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    protected void tearDown()
    {
    }
    
    /**
     * Teste die einfache Erzeugung eines Fahrgastes.
     * Stelle sicher, dass Abholpunkt und Ziel gesetzt sind.
     */
    @Test
    public void testErzeugung()
    {
        Position abholpunkt = new Position();
        Position ziel = new Position();
        Fahrgast fahrgast1 = new Fahrgast(abholpunkt, ziel);
        assertEquals(ziel, fahrgast1.gibZiel());
        assertEquals(abholpunkt, fahrgast1.gibAbholpunkt());
    }
}
