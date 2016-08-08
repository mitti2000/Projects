
/**
 * Definiert ein Datum mittels Tag, Monat und Jahr
 * 
 * @author Thomas Mittermair 
 * @version 7.8.16
 */
public class Datum
{
    private int tag;
    private int monat;
    private int jahr;
    
    /** Konstruktor: Setzt das Abluafdatum auf die gewünschten Daten. Es wirk keine Überprüfung vorgenommen.
     * @param tag Tag als int
     * @param monat Monat als int
     * @param jahr Jahr als int
     */
    public Datum(int tag, int monat, int jahr){
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }
    
    /**
     * Gibt das Datum als String zurück
     * 
     * @return Das Datum als String
     */
    public String getDatum(){
        return tag + "." + monat + "." + jahr;
    }
    
    
    /**
     * Setzt das Datum auf die gewünschten Daten
     * 
     * @param tag Tag als int
     * @param monat Monat als int
     * @param jar Jahr als int
     */
    public void setDatum(int tag, int monat, int jahr){
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }
}
