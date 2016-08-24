
/**
 * Beschreiben Sie hier die Klasse Fach.
 * 
 * @author Alexander Palmer
 * @version 1.0 (28.09.2015)
 */
public class Fach
{
    private String bezeichnung;
    private String lehrperson;
    private int anzahlLektionen;
    private double note1;
    private double note2;
    private double note3;
    
    public Fach(String bezeichnung, String lehrperson, int anzahlLektionen)
    {
        this.bezeichnung = bezeichnung;
        this.lehrperson = lehrperson;
        this.anzahlLektionen = anzahlLektionen;
        this.note1=0.0;
        this.note2=0.0;
        this.note3=0.0;
    }
    
    public String gibBezeichnung()
    {
        return this.bezeichnung;
    }
    
    public String gibLehrperson()
    {
        return this.lehrperson;
    }
    
    public int gibAnzahlLektionen()
    {
        return this.anzahlLektionen;
    }
    
    public double gibNote1()
    {
        return this.note1;
    }
    
    public double gibNote2()
    {
        return this.note2;
    }
    
    public double gibNote3()
    {
        return this.note3;
    }
    
    public int gibWievieleNotenGeschrieben()
    {
        int anzahl=0;
        if(this.note1!=0.0)
        {
            anzahl++;
        }
        else if(this.note2!=0.0)
        {
            anzahl++;
        }
        else if(this.note3!=0.0) {
            anzahl++;
        }
        return anzahl;
    }
    
    public boolean setzeNote1(double note)
    {
        if(this.note1!=0.0)
        {
            this.note1=note;
            return true;
        }
        return false;
    }
    public boolean setzeNote2(double note)
    {
        if(this.note2!=0.0)
        {
            this.note2=note;
            return true;
        }
        return false;
    }
    public boolean setzeNote3(double note)
    {
        if(this.note3!=0.0)
        {
            this.note3=note;
            return true;
        }
        return false;
    }
    
    public double gibNotenSchnitt()
    {
        double summe = 0.0;
        if(this.note1!=0.0)
        {
            summe+=this.note1;
        }
        else if(this.note2!=0.0)
        {
            summe+=this.note2;
        }
        else if(this.note3!=0.0)
        {
            summe+=this.note3;
        }
        return summe/gibWievieleNotenGeschrieben();
    }
    
    public double gibBesteNote()
    {
        double besteNote = 0.0;
        if(this.note1>besteNote)
        {
            besteNote = this.note1;
        }
        else if (this.note2>besteNote)
        {
            besteNote = this.note2;
        }
        else if (this.note3>besteNote)
        {
            besteNote = this.note3;
        }
        return besteNote;
    }
}