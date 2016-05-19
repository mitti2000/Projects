
/**
 * Simulation von Fahrg�sten, die Fahrten bei einem
 * Taxi-Unternehmen anfragen.
 * Fahrg�ste sollten in zuf�lligen Intervallen erzeugt werden.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class Fahrgastquelle
{
    private Taxiunternehmen unternehmen;

    /**
     * Konstruktor f�r Objekte der Klasse FahrgastQuelle.
     * @param unternehmen das gew�hlte Unternehmen. Darf nicht null sein.
     * @throws NullPointerException wenn unternehmen null ist.
     */
    public Fahrgastquelle(Taxiunternehmen unternehmen)
    {
        if(unternehmen == null) {
            throw new NullPointerException("company");
        }
        this.unternehmen = unternehmen;
    }

    /**
     * Lasse diese Quelle einen neuen Fahrgast erzeugen
     * und rufe beim Unternehmen ein Taxi f�r ihn.
     * @return true wenn die Anfrage erfolgreich ist, false sonst.
     */
    public boolean erbitteAbholung()
    {
        Fahrgast fahrgast = erzeugeFahrgast();
        return unternehmen.taxirufFuer(fahrgast);
    }

    /**
     * Erzeuge einen neuen Fahrgast.
     * @return den erzeugten Fahrgast.
     */
    private Fahrgast erzeugeFahrgast()
    {
        return new Fahrgast(new Position(), new Position());
    }
}
