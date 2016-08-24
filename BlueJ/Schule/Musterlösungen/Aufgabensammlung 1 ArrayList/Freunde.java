import java.util.ArrayList;
/**
 * Diese Klasse verwaltet eine unbegrenzte Anzahl von Namen.
 * 
 * @author Alexander Palmer
 * @version 22.06.2015
 */
public class Freunde
{
    private ArrayList<String> meineFreunde;

    /**
     * Erzeugt eine Instanz von ArrayList und stellt
     * die Sammlung der Klasse zur Verfügung.
     */
    public Freunde()
    {
        meineFreunde = new ArrayList<String>();
    }

    /**
     * Fügt eine neue String-Referenz der Sammlung hinzu
     * @param name Name eines Freundes
     */
    public boolean hinzufuegen(String name)
    {
        if(name!=null)
        {
            return meineFreunde.add(name);
        } 
        return false;
    }

    /**
     * Liefert den Namen eines Freundes an einer bestimmten
     * Position innerhalb der Sammlung
     * @param position Index  der Sammlung, beginnend bei 0
     * @return liefert den gefundenen Namen an der Position oder null
     */
    public String gibName(int position)
    {
        if(position >= 0 && position < meineFreunde.size())
        {
            return meineFreunde.get(position);
        }
        return null;
    }

    /**
     * Liefert die Anzahl der gespeicherten Referenzen der Sammlung
     * @return Anzahl gespeicherter Refernzen in Sammlung
     */
    public int gibAnzahlFreunde() 
    {
        return meineFreunde.size();
    }

    /**
     * Entfernt eine Objektreferenz innerhalb der Sammlung, wenn
     * Position gültig ist
     * @param position Index eines Elements beginnend bei 0
     * @return true wenn das Entfernen geklappt hat, ansonsten false
     */
    public boolean loescheFreund(int position)
    {
        int aktAnzahl=meineFreunde.size();
        if(position >= 0 && position < meineFreunde.size())
        {
            meineFreunde.remove(position);
        }

        if (aktAnzahl > meineFreunde.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gibt alle Namen der Sammlung in der Konsole aus
     */
    public void alleNamenAusgeben()
    {
        for(String name : meineFreunde)
        {
            System.out.println(name);
        }
    }

    /**
     * Sucht einen Namen in der Sammlung und liefert true,
     * wenn Name in der Sammlung vorhanden
     * @param name Der gesuchte Name
     * @return true wenn Name gefunden, ansonsten false
     */
    public boolean sucheFreund(String name)
    {
        if(name!=null)
        {
            return meineFreunde.contains(name);
        }
        return false;
    }

    /**
     * Liefert die Position (Index) eines Namens innerhalb der Sammlung
     * @param name Gesuchter Name der Person
     * @return der Index der gesuchten Person
     */
    public int gibPosition(String name)
    {
        if(name!=null)
        {
            return meineFreunde.indexOf(name);
        }
        return -1;
    }
}