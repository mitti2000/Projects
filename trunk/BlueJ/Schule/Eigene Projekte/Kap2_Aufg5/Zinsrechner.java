
/**
 * Beschreiben Sie hier die Klasse Zinsrechner.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Zinsrechner
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private double kapital;
    private int anlagetage;
    private double zinssatz;

    /**
     * Konstruktor für Objekte der Klasse Zinsrechner
     */
    public Zinsrechner(double kapital, int anlagetage, double zinssatz)
    {
        this.kapital = kapital;
        this.anlagetage = anlagetage;
        this.zinssatz = zinssatz;
    }

    public double gibKapital(){
        return kapital;
    }
    
    public double gibAnlagetage(){
        return anlagetage;
    }
    
    public double gibZinssatz(){
        return zinssatz;
    }
    
    public double berechneZins(){
        double zinsbetrag = (kapital * zinssatz * anlagetage) / (100 * 360);
        System.out.println("Zinsbetrag ist " + zinsbetrag);
        return zinsbetrag;
    }
    
    public double berechneNeuesVermoegen(){
        double zinsbetrag = berechneZins();
        double neuesVermoegen = kapital + zinsbetrag;
        System.out.println("Neues Vermoegen ist" + neuesVermoegen);
        return neuesVermoegen;

    }
}
