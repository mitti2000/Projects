
/**
 * Beschreiben Sie hier die Klasse Auge.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Auge
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private boolean zustand;
    

    /**
     * Konstruktor für Objekte der Klasse Auge
     */
    public Auge()
    {
        zustand = false;
    }

    public boolean gibAugeZustand(){
        return zustand;
    }
    
    public void oeffneAuge(){
        zustand = true;
    }
    
    public void schliesseAuge(){
        zustand = false;
    }
    
}
