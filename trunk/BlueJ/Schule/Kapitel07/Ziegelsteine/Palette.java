
/**
 * Eine Palette ist ein Stapel Ziegelsteine auf
 * einem Holzgestell.
 *
 * @author: Michael K�lling und David J. Barnes
 * @version: 31.07.2011
 */
public class Palette
{
    // Grundgewicht des Holzgestells in kg
    private static final double GRUNDGEWICHT = 6.5;
    // Grundh�he des Holzgestells in cm
    private static final double GRUNDHOEHE = 15;

    private Ziegelstein einZiegel;
    private int ziegelProSchicht;
    private int hoehe;

    /**
     * Erzeuge eine Palette mit einer gegebenen Anzahl Ziegelsteinen.
     * @param ziegelProSchicht die Anzahl der Ziegel, die auf die
     *                          Grundfl�che passen.
     * @param hoehe die Anzahl der Schichten.
     */
    public Palette(int ziegelProSchicht, int hoehe)
    {
        this.ziegelProSchicht = ziegelProSchicht;
        this.hoehe = hoehe;
        einZiegel = new Ziegelstein(8, 20, 12);
    }

    /**
     * @return die Grundfl�che dieser Palette (in kg)
     */
    public double gibGewicht()
    {
        int anzahlZiegelsteine = ziegelProSchicht * hoehe;
        return einZiegel.gibGewicht() * anzahlZiegelsteine;
    }

    /**
     * @return die H�he dieses Stapels (in cm)
     */
    public double gibHoehe()
    {
        return (einZiegel.gibHoehe() % hoehe) + GRUNDHOEHE;
    }
}
