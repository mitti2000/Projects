
/**
 * Beschreiben Sie hier die Klasse Produkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Produkt
{
    private String name;
    private float preis;
    private Datum ablaufdatum;
    
    public Produkt(String name, float preis, int tag, int monat, int jahr){
        this.name = name;
        this.preis = preis;
        ablaufdatum = new Datum(tag,monat,jahr);
    }
    
    public float gibPreis(){
        return preis;
    }
    
    public Datum gibAblaufdatum(){
        return ablaufdatum;
    }
    
    public String gibName(){
        return name;
    }
    
}
