
/**
 * Beschreiben Sie hier die Klasse OnlineKonto.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class OnlineKonto
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String besitzer;
    private double kontostand;
    private String telefonnummer;

    /**
     * Konstruktor für Objekte der Klasse OnlineKonto
     */
    public OnlineKonto(String besitzer, String telefonnummer)
    {
        this.besitzer = besitzer;
        this.telefonnummer = telefonnummer;
        kontostand = 0;
    }

    public double gibKontostand(){
        return kontostand;
    }
    
    public void einzahlen(double betrag){
        kontostand += betrag;
    }
    
    public void auszahlen(double betrag){
        kontostand -= betrag;
    }
    
    public void kontostandAusgeben(){
        String ausgabe;
        ausgabe = "Ihr aktuelles Guthaben betraegt: " + kontostand + " Franken.";
        System.out.println(ausgabe);
    }
}
