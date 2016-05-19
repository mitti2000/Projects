import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Eine Simulation, die eine Menge von Akteuren zum
 * Agieren auffordert.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class Simulation
{
    private List<Akteur> akteure;
    private int schritt;

    /**
     * Erzeuge die anf�nglichen Akteure der Simulation.
     */
    public Simulation()
    {
        akteure = new LinkedList<Akteur>();
        schritt = 0;
        Stadt stadt = new Stadt();
        Taxiunternehmen unternehmen = new Taxiunternehmen(stadt);
        Fahrgastquelle quelle = new Fahrgastquelle(stadt, unternehmen);
        
        akteure.addAll(unternehmen.gibFahrzeuge());
        akteure.add(quelle);
        akteure.add(new StadtGUI(stadt));
    }
    
    /**
     * F�hre die Simulation f�r eine festgelegte Anzahl
     * an Schritten durch.
     * Mache nach jedem Schritt eine kurze Pause, damit
     * die GUI mithalten kann.
     */
    public void starten()
    {
        for(int i = 0; i < 500; i++){
            schritt++;
            schritt();
            wait(100);
        }
    }

    /**
     * F�hre einen Schritt der Simulation durch.
     */
    public void schritt()
    {
        for(Akteur akteur : akteure) {
            akteur.agiere();
        }
    }
    
    /**
     * Warte die angegebene Anzahl an Millisekunden.
     * Eine einfache M�glichkeit, eine kleine Verz�gerung
     * einzubauen.
     * @param millisekunden die Anzahl der zu wartenden
     *                      Millisekunden.
     */
    private void wait(int millisekunden)
    {
        try
        {
            Thread.sleep(millisekunden);
        } 
        catch (InterruptedException e)
        {
            // Exception ignorieren
        }
    }
}
