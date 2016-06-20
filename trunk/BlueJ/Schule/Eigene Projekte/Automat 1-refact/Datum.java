
/**
 * Beschreiben Sie hier die Klasse Datum.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Datum
{
    private int tag;
    private int monat;
    private int jahr;
    
    public Datum(int tag, int monat, int jahr){
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }
    
    public String gibDatum(){
        return tag+"."+monat+"."+jahr;
    }
}
