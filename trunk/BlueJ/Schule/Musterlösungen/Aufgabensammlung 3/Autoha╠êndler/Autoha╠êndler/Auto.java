
/**
 * Beschreiben Sie hier die Klasse Auto.
 * 
 * @author Alexander Palmer
 * @version 1.0 (28.09.2015)
 */
public class Auto
{
    private String marke;
    private String modell;
    private int kilometerstand;
    private String serienNummer;
    private double einkaufspreis;
    private double verkaufspreis;
    private Datum ankaufsDatum;
    private Datum verkaufsDatum;

    public Auto(String marke, String modell, int kilometerstand, double einkaufspreis, String serienNummer, Datum ankaufsDatum)
    {
        this.marke = marke;
        this.modell = modell;
        this.kilometerstand = kilometerstand;
        this.serienNummer = serienNummer;
        this.einkaufspreis = einkaufspreis;
        this.ankaufsDatum = ankaufsDatum;
        this.verkaufsDatum = null;
    }

    public String gibMarke()
    {
        return this.marke;
    }

    public String gibModell()
    {
        return this.modell;
    }

    public int gibKilomenterstand()
    {
        return this.kilometerstand;
    }

    public String gibSerienNummer()
    {
        return this.serienNummer;
    }

    public double gibEinkaufspreis()
    {
        return this.einkaufspreis;
    }

    public double gibVerkaufspreis()
    {
        return this.verkaufspreis;
    }

    public boolean istFahrzeugVerkauft()
    {
        if(verkaufsDatum!=null)
        {
            return true;
        }
        return false;
    }

    public Datum gibAnkaufsDatum()
    {
        return this.ankaufsDatum;
    }

    public Datum gibVerkaufsDatum()
    {
        return  this.verkaufsDatum;
    }

    public boolean equals(Auto auto)
    {
        if(this.gibMarke().equals(auto.gibMarke()) &&
        this.gibModell().equals(auto.gibModell()) &&
        this.gibKilomenterstand()==auto.gibKilomenterstand() &&
        this.gibSerienNummer().equals(auto.gibSerienNummer()) &&
        this.gibEinkaufspreis()==auto.gibEinkaufspreis() &&
        this.gibAnkaufsDatum().equals(auto.gibAnkaufsDatum()))
        {
            return true; 
        }
        return false;
    }
}
