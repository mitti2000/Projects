import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * Modell eines Taxiunternehmens, das verschiedene Fahrzeugtypen
 * betreibt.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class Taxiunternehmen  
{
    private List<Fahrzeug> fahrzeuge;

    /**
     * Konstruktor f�r Objekte der Klasse TaxiUnternehmen
     */
    public Taxiunternehmen()
    {
        fahrzeuge = new LinkedList<Fahrzeug>();
    }

    /**
     * Rufe ein Taxi f�r den angegebenen Fahrgast.
     * @param fahrgast der Fahrgast, der gefahren werden m�chte.
     * @return ob ein freies Fahrzeug verf�gbar ist.
     */
    public boolean taxirufFuer(Fahrgast fahrgast)
    {
        Fahrzeug fahrzeug = waehleFahrzeug();
        if(fahrzeug != null) {
            fahrzeug.setzeAbholpunkt(fahrgast.gibAbholpunkt());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Ein Fahrzeug hat den Abholpunkt erreicht.
     * @param fahrzeug das Fahrzeug am Abholpunkt.
     */
    public void ankunftAmAbholpunkt(Fahrzeug fahrzeug)
    {
    }
    
    /**
     * Ein Fahrzeug hat das Ziel eines Fahrgastes erreicht.
     * @param fahrzeug das Fahrzeug am Zielpunkt.
     * @param fahrgast der abgesetzte Fahrgast.
     */
    public void ankunftAmZiel(Fahrzeug fahrzeug,
                              Fahrgast fahrgast)
    {
    }
    
    /**
     * W�hle ein freies Fahrzeug, wenn verf�gbar.
     * @return ein freies Fahrzeug oder null, wenn keines verf�gbar ist.
     */
    private Fahrzeug waehleFahrzeug()
    {
        Iterator<Fahrzeug> it = fahrzeuge.iterator();
        while(it.hasNext()) {
            Fahrzeug fahrzeug = it.next();
            if(fahrzeug.istFrei()) {
                return fahrzeug;
            }
        }
        return null;
    }
}
