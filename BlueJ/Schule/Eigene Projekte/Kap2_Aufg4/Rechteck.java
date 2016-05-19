
/**
 * Beschreiben Sie hier die Klasse Rechteck.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Rechteck
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int laenge;
    private int breite;

    /**
     * Konstruktor für Objekte der Klasse Rechteck
     */
    public Rechteck(int breite, int laenge)
    {
        this.breite = breite;
        this.laenge = laenge;
    }

    public void berechneUmfange(){
        int umfang = (breite*2) + (laenge * 2);
        System.out.println("Umfang des Rechtecks ist " + umfang + ".");
    }
    
    public void berechneFlaeche(){
        int umfang = laenge * breite;
        System.out.println("Fläche des Rechtecks ist " + umfang + ".");
    }
    
    public void pruefeObQuadrat(){
        if (laenge == breite) System.out.println("Ist ein Quadrat");
        else System.out.println("Ist kein Quadrat");
    }
}
