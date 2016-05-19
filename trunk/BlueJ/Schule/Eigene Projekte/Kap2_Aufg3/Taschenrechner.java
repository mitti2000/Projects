
/**
 * Beschreiben Sie hier die Klasse Taschenrechner.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Taschenrechner
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private double zahl1;
    private double zahl2;
    private double resultat;

    /**
     * Konstruktor für Objekte der Klasse Taschenrechner
     */
    public Taschenrechner()
    {
        zahl1 = 0.0;
        zahl2 = 0.0;
        resultat = 0.0;
    }

    public double gibZahl1(){
        return zahl1;
    }
    
    public double gibZahl2(){
        return zahl2;
    }
    
    public double gibResultat(){
        return resultat;
    }
    
    public void addieren (double zahl1, double zahl2){
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
        
        resultat = zahl1 + zahl2;
    }
    
    public void subtrahieren (double zahl1, double zahl2){
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
        
        resultat = zahl1 - zahl2;
    }
    
    public void multiplizieren (double zahl1, double zahl2){
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
        
        resultat = zahl1 * zahl2;
    }
    
    public void dividieren (double zahl1, double zahl2){
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
        
        resultat = zahl1 / zahl2;
    }
}
