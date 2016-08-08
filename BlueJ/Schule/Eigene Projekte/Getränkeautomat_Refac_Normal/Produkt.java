
/**
 * Klasse definiert ein Produkt mit Name, Preis, Anzahl und Ablaufdatum
 * 
 * @author Thomas Mittermair 
 * @version 7.8.16
 */
public class Produkt
{
    private String name;
    private double preis;
    private Datum ablaufdatum;
    private int anzahl;
    
    /**
     * Kontruktor erstellt ein Produkt mit Name, Preis, Anzahl und Ablaufdatum. Das Ablaufdatum muss
     * mit Tag, Monat und Jahr als int angegeben werden.
     * 
     * @param name Name als String
     * @param preis Preis als double
     * @param anzahl Anzahl als int
     * @param tag Ablauftag als int
     * @param monat Ablaufmonat als int
     * @param jahr Ablaufjahr als int
     */
    public Produkt (String name, double preis, int anzahl, int tag, int monat, int jahr){
        this.name = name;
        this.preis = preis;
        this.anzahl = anzahl;
        ablaufdatum = new Datum(tag, monat, jahr);
    }
    
    /**
     * Gibt den Namen des Prdukts als String zurück
     * 
     * @return Name als String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gibt den Preis des Prdukts als double zurück
     * 
     * @return Preis als double
     */
    public double getPreis(){
        return preis;
    }
    
    /**
     * Gibt die Anzahl des Prdukts als int zurück
     * 
     * @return Anzahl als int
     */
    public int getAnzahl(){
        return anzahl;
    }
      
    /**
     * Gibt das Ablaufdatum des Prdukts als String zurück
     * 
     * @return Abluafdatum als String
     */
    public String getAblaufdatum(){
        return ablaufdatum.getDatum();
    }
    
    /**
     * Setzt den Namen des Produkts
     * 
     * @param name Name als String
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Setzt den Preis des Produkts
     * 
     * @param preis Preis als double
     */
    public void setPreis(double preis){
        this.preis = preis;
    }
    
    /**
     * Setzt die Anzahl des Produkts
     * 
     * @param anzahl Anzahl als int
     */
    public void setAnzahl(int Anzahl){
        this.anzahl = anzahl;
    }
    
    /**
     * Setzt das Ablaufdatum des Produkts
     * 
     * @param tag Tag als int
     * @param monat Monat als int
     * @param jar Jahr als int
     */
    public void setAblaufdatum(int tag, int monat, int jahr){
        ablaufdatum.setDatum(tag, monat, jahr);
    }
}
