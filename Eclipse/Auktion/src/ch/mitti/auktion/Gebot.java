package ch.mitti.auktion;

/**
 * Eine Klasse, die Gebote in einer Auktion modelliert.
 * Ein Gebot enth�lt eine Referenz auf die Person, die
 * das Gebot abgegeben hat, und die H�he des Gebots.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 31.07.2011
 */
public class Gebot
{
    // die Person, die das Gebot abgegeben hat.
    private final Person bieter;
    // Die H�he des Gebots. Da dies potentiell ein sehr hohes
    // Gebot sein kann, wurde der Basistyp 'long' gew�hlt.
    private final long hoehe;

    /**
     * Erzeuge ein Gebot.
     * @param bieter die Person, die das Gebot abgibt.
     * @param hoehe die H�he des Gebots.
     */
    public Gebot(Person bieter, long hoehe)
    {
        this.bieter = bieter;
        this.hoehe = hoehe;
    }

    /**
     * Liefere den Bieter dieses Gebots.
     * @return den Bieter.
     */
    public Person gibBieter()
    {
        return bieter;
    }

    /**
     * Liefere die H�he dieses Gebots.
     * @return die H�he dieses Gebots.
     */
    public long gibHoehe()
    {
        return hoehe;
    }
}
