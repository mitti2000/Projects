
/**
 * Beschreiben Sie hier die Klasse Datum.
 * 
 * @author Alexander Palmer
 * @version 1.0 (28.09.2015)
 */
public class Datum
{
    private int tag;
    private int monat;
    private int jahr;

    public Datum (int tag, int monat, int jahr)
    {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int gibTag()
    {
        return this.tag;
    }

    public int gibMonat()
    {
        return this.monat;
    }

    public int gibJahr()
    {
        return this.jahr;
    }

    public String gibDatumAlsString()
    {
        String datum="";
        if(tag<10)
        {
            datum+="0"+tag+".";
        }
        else 
        {
            datum+=tag+".";
        }

        if(monat<10)
        {
            datum+="0"+monat+".";
        }
        else 
        {
            datum+=monat+".";
        }
        datum+=jahr+"";
        return datum;
    }

    public boolean equals(Datum datum)
    {
        if(this.gibTag()==datum.gibTag() &&
        this.gibMonat()==datum.gibMonat() &&
        this.gibJahr()==datum.gibJahr())
        {
            return true;
        }
        return false;
    }
}
