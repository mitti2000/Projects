import java.util.ArrayList;
import java.util.Iterator;
/**
 * Beschreiben Sie hier die Klasse Student.
 * 
 * @author Alexander Palmer
 * @version Version 1.0, 28.09.2015
 */
public class Student
{
    private String vorname;
    private String nachname;
    private int studentenNummer;
    private ArrayList<Fach> faecher;
    
    public Student(String vorname, String nachname, int studentenNummer)
    {
        this.vorname=vorname;
        this.nachname=nachname;
        this.studentenNummer=studentenNummer;
        this.faecher = new ArrayList<Fach>();
    }
    
    public boolean FachHinzufuegen(Fach fach)
    {
        if(fach!=null)
        {
            return faecher.add(fach);
        }
        return false;
    }
    
    public Fach sucheFachNachBezeichnung(String bezeichnung)
    {
        if(bezeichnung!=null)
        {
            for(Fach fach : faecher)
            {
                if(fach.gibBezeichnung().equals(bezeichnung))
                {
                    return fach;
                }
            }
        }
        return null;
    }
    
    public ArrayList<String> gibAlleFachBezeichnungen()
    {
        ArrayList<String> fachbezeichnungen = new ArrayList<String>();
        int count=0;
        while(count<faecher.size())
        {
            Fach f = faecher.get(count);
            String bezeichnung = f.gibBezeichnung();
            fachbezeichnungen.add(bezeichnung);
            count++;
        }
        return fachbezeichnungen;
    }
    
    public double gibBesteNotenSchnittAllerFaecher()
    {
        double besteNote = 0.0;
        Iterator<Fach> it = faecher.iterator();
        while(it.hasNext())
        {
            Fach f = it.next();
            double note = f.gibNotenSchnitt();
            if(note>besteNote)
            {
                besteNote=note;
            }
        }
        return besteNote;
    }
    
    public double gibBesteNoteEinesFachs(String bezeichnung)
    {
        if(bezeichnung!=null)
        {
            for(Fach f : faecher)
            {
                if(f.gibBezeichnung().equals(bezeichnung))
                {
                    return f.gibBesteNote();
                }
            }
        }
        return -1;
    }
    
    public ArrayList<Fach> sucheFaecherMitBestimmterAnzahlNoten(int anzahl)
    {
        ArrayList<Fach> faecherMitBestimmterAnzahlNoten = new ArrayList<Fach>();
        int count = 0;
        while(count < faecher.size())
        {
            Fach f = faecher.get(count);
            if(f.gibWievieleNotenGeschrieben()==anzahl)
            {
                faecherMitBestimmterAnzahlNoten.add(f);
            }
            count++;
        }
        return faecherMitBestimmterAnzahlNoten;
    }
    
    public int gibFachMitKleinsterLektionenAnzahl()
    {
        int kleinsteLektionenAnzahl=1000;
        Iterator<Fach> it = faecher.iterator();
        while(it.hasNext())
        {
            Fach f = it.next();
            if(f.gibAnzahlLektionen()<kleinsteLektionenAnzahl)
            {
                kleinsteLektionenAnzahl = f.gibAnzahlLektionen();
            }
        }
        return kleinsteLektionenAnzahl;
        
    }
}
