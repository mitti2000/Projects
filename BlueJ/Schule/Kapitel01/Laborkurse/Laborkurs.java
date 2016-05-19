import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse Laborkurs definiert Teilnehmerlisten von Laborkursen.
 * Ein Exemplar der Klasse Laborkurs h�lt Informationen �ber Zeit, Raum 
 * und alle Teilnehmer sowie �ber den Namen des Dozenten.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 31.07.2011
 */
public class Laborkurs
{
    private String dozent;
    private String raum;
    private String tagUndZeit;
    private ArrayList<Student> studenten;
    private int teilnehmergrenze;
    
    /**
     * Erzeuge einen Laborkurs mit einer Teilnehmerbegrenzung. Alle 
     * anderen Details werden mit Standardwerten vorbelegt.
     */
    public Laborkurs(int maximaleTeilnehmerzahl)
    {
        dozent = "N.N.";
        raum = "N.N.";
        tagUndZeit = "N.N.";
        studenten = new ArrayList<Student>();
        teilnehmergrenze = maximaleTeilnehmerzahl;
    }

    /**
     * Trage einen Studenten in diesen Kurs ein.
     */
    public void trageStudentEin(Student neuerStudent)
    {
        if(studenten.size() == teilnehmergrenze) {
            System.out.println("Der Kurs ist voll, keine Eintragung mehr m�glich.");
        }
        else {
            studenten.add(neuerStudent);
        }
    }
    
    /**
     * Liefere die Anzahl der in diesen Kurs momentan eingetragenen Studenten.
     */
    public int anzahlStudenten()
    {
        return studenten.size();
    }
    
    /**
     * Setze den Raum f�r diesen Kurs.
     */
    public void setzeRaum(String raumnummer)
    {
        raum = raumnummer;
    }
    
    /**
     * Setze Wochentag und Anfangszeit f�r diesen Kurs. Der Parameter
     * sollte das Format "montags, 16 Uhr" haben.
     */
    public void setzeTermin(String tagUndZeit)
    {
        this.tagUndZeit = tagUndZeit;
    }
    
    /**
     * Setze den Namen des Dozenten f�r diesen Laborkurs.
     */
    public void setzeDozent(String dozentenname)
    {
        dozent = dozentenname;
    }
    
    /**
     * Gib eine Liste der Teilnehmer zusammen mit den weiteren Details
     * dieses Kurses auf die Konsole aus.
     */
    public void listeAusgeben()
    {
        System.out.println("Laborkurs: " + tagUndZeit);
        System.out.println("Dozent: " + dozent + "   Raum: " + raum);
        System.out.println("Teilnehmerliste:");
        for (Student student : studenten) {
            student.ausgeben();
        }
        System.out.println("Teilnehmeranzahl: " + anzahlStudenten());
    }
}
