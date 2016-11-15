import java.util.ArrayList;

/**
 * Die Klasse Datenbank bietet Möglichkeiten zum Speichern
 * von CD- und DVD-Objekten. Eine Liste aller CDs und DVDs
 * kann auf der Konsole ausgegeben werden.
 * 
 * Diese Version speichert die Daten nicht im Dateisystem und
 * bietet keine Suchfunktion.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public class Datenbank
{
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    /**
     * Erzeuge eine leere Datenbank.
     */
    public Datenbank()
    {
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
    }

    /**
     * Erfasse die gegebene CD in dieser Datenbank.
     * @param dieCD die einzutragende CD.
     */
    public void erfasseCD(CD dieCD)
    {
        cds.add(dieCD);
    }

    /**
     * Erfasse die gegebene DVD in dieser Datenbank.
     * @param dieDVD die einzutragende DVD.
     */
    public void erfasseDVD(DVD dieDVD)
    {
        dvds.add(dieDVD);
    }

    /**
     * Gib eine Liste aller aktuell gespeicherten CDs und
     * DVDs auf der Konsole aus.
     */
    public void auflisten()
    {
        // Liste der CDs ausgeben
        for(CD cd : cds) {
            cd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }

        // Liste der DVDs ausgeben
        for(DVD dvd : dvds) {
            dvd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }
    }
}
