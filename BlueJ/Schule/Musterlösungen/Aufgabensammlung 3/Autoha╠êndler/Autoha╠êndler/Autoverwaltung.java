import java.util.ArrayList;
import java.util.Iterator;
/**
 * Beschreiben Sie hier die Klasse Autoverwaltung.
 * 
 * @author Alexander Palmer
 * @version 1.0 (28.09.2015)
 */
public class Autoverwaltung
{
    private ArrayList<Auto> autos;

    public Autoverwaltung()
    {
        autos = new ArrayList<Auto>();
    }

    public boolean hinzufuegen(Auto auto)
    {
        if(auto!=null)
        {
            return this.autos.add(auto);
        }
        return false;
    }

    public Auto sucheFahrzeug(Auto auto)
    {
        for(Auto a : autos)
        {
            if(a.equals(auto))
            {
                return auto;
            }
        }
        return null;
    }

    public int gibAnzahlBestimmteMarke(String marke)
    {
        int anzahl=0;
        for(Auto a : autos)
        {
            if(a.gibMarke().equals(marke))
            {
                anzahl++;
            }
        }
        return anzahl;
    }

    public int gibAnzahlBestimmteMarkenModelle(String marke, String modell)
    {
        if(marke!=null && modell!=null)
        {
            int anzahl=0;
            int count=0;
            while(count<autos.size())
            {
                Auto a = autos.get(count);
                if(a.gibMarke().equals(marke) && a.gibModell().equals(modell))
                {
                    anzahl++;
                }
                count++;
            }
            return anzahl;
        }
        return -1;
    }

    public Auto gibGuenstigesFahrzeugImVerkauf()
    {
        if(autos.size()>0) {
            Auto guenstigstesAuto = autos.get(0);
            Iterator<Auto> it = autos.iterator();
            while(it.hasNext())
            {
                Auto a = it.next();
                if(a.gibVerkaufspreis()>guenstigstesAuto.gibVerkaufspreis())
                {
                    guenstigstesAuto = a;
                }
            }
            return guenstigstesAuto;
        }
        return null;
    }

    public double gibGesamtenEinkaufswertAllerNichtVerkaufterFahrzeuge()
    {
        double wert = 0.0;
        for(Auto a : autos)
        {
            if(a.gibVerkaufsDatum()==null)
            {
                wert+=a.gibEinkaufspreis();
            }
        }
        return wert;
    }

    public ArrayList<Auto> gibFahrzeugeVerkauftAnDatum(Datum datum)
    {
        ArrayList<Auto> verkaufteAutos = new ArrayList<Auto>();
        int count=0;
        while(count<autos.size())
        {
            Auto a = autos.get(count);
            if(a.gibVerkaufsDatum().equals(datum))
            {
                verkaufteAutos.add(a);
            }
            count++;
        }
        return verkaufteAutos;
    }

    public double gibBesteVerkaufsMarge()
    {
        double besteMarge=0.0;
        Iterator<Auto> it = autos.iterator();
        while(it.hasNext())
        {
            Auto a = it.next();
            if(a.gibVerkaufsDatum()!=null)
            {
                double ankaufspreis = a.gibEinkaufspreis();
                double verkaufspreis = a.gibVerkaufspreis();
                double marge = verkaufspreis - ankaufspreis;
                if(marge>besteMarge)
                {
                    besteMarge=marge;
                }
            }

        }
        return besteMarge;
    }
}
