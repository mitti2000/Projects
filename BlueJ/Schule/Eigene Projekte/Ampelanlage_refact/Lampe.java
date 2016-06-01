
/**
 * Beschreiben Sie hier die Klasse Lampe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Lampe
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private boolean leuchtet;
    
    public void lampeEinschalten(){
        if (!leuchtet) leuchtet = true;
    }
    
    public void lampeAusschalten(){
        if (leuchtet) leuchtet = false;
    }
    
    public boolean gibZustand(){
        return leuchtet;
    }
}
