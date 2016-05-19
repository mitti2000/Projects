import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
    
/**
 * Eine Stadt, in der sich Gegenst�nde befinden.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class Stadt
{
    private List<Object> gegenstaende;
    private int breite;
    private int hoehe;
    
    private static final int STANDARD_BREITE = 35;
    private static final int STANDARD_HOEHE = 35;

    /**
     * Konstruktor f�r Objekte der Klasse Stadt
     * @param breite die Breite der Stadt.
     * @param hoehe die H�he der Stadt.
     */
    public Stadt(int breite, int hoehe)
    {
        if(breite < 1) {
            throw new IllegalArgumentException(
                        "Breite muss positiv sein: " +
                        breite);
        }
        if(hoehe < 1) {
            throw new IllegalArgumentException(
                        "H�he muss positiv sein: " +
                        hoehe);
        }
        this.breite = breite;
        this.hoehe = hoehe;
        gegenstaende = new LinkedList<Object>();
    }
    
    /**
     * Erzeuge eine Stadt mit einer Standardgr��e.
     */
    public Stadt()
    {
        this(STANDARD_BREITE, STANDARD_HOEHE);
    }
    
    /**
     * @return einen Iterator �ber die Gegenst�nde.
     */
    public Iterator gibGegenstaende()
    {
        return gegenstaende.iterator();
    }

    /**
     * F�ge den gegebenen Gegenstand in die Stadt ein.
     * @param gegenstand der einzuf�gende Gegenstand.
     */
    public void gegenstandEinfuegen(Object gegenstand)
    {
        if(gegenstaende.contains(gegenstand)) {
            throw new IllegalArgumentException(
                gegenstand + " bereits in der Stadt vorhanden.");
        }
        gegenstaende.add(gegenstand);
    }

    /**
     * Entferne den gegebenen Gegenstand aus der Stadt.
     * @param gegenstand der zu entfernende Gegenstand.
     */
    public void gegenstandEntfernen(Object gegenstand)
    {
        if(!gegenstaende.remove(gegenstand)) {
            throw new IllegalArgumentException(
                        gegenstand + " ist nicht in der Stadt.");
        }
    }
        
    /**
     * @return eine String-Darstellung der Stadt.
     */
    public String toString()
    {
        return "Stadt mit Gr��e " + breite + " x " + hoehe;
    }
    
    /**
     * @return die Breite dieser Stadt.
     */
    public int gibBreite()
    {
        return breite;
    }
    
    /**
     * @return die H�he dieser Stadt.
     */
    public int gibHoehe()
    {
        return hoehe;
    }
}
