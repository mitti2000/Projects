import java.util.List;
import java.util.Random;

/**
 * Ein einfaches Modell eines Hasen.
 * Ein Hase altert, bewegt sich, geb�rt Nachwuchs und stirbt.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class Hase extends Tier
{
    // Eigenschaften aller Hasen (Klassenvariablen).

    // Das Alter, in dem ein Hase geb�rf�hig wird.
    private static final int GEBAER_ALTER = 5;
    // Das H�chstalter eines Hasen.
    private static final int MAX_ALTER = 40;
    // Die Wahrscheinlichkeit, mit der ein Hase Nachwuchs geb�rt.
    private static final double GEBAER_WAHRSCHEINLICHKEIT = 0.12;
    // Die maximale Gr��e eines Wurfes (Anzahl der Jungen)
    private static final int MAX_WURFGROESSE = 4;
    // Ein gemeinsamer Zufallsgenerator, der die Geburten steuert.
    private static final Random rand = Zufallssteuerung.gibZufallsgenerator();
    
    // Individuelle Eigenschaften eines Hasen (Instanzfelder).
    
    // Das Alter dieses Hasen.
    private int alter;
    // Ist dieser Hase noch lebendig?

    /**
     * Erzeuge einen neuen Hasen. Ein neuer Hase kann das Alter 0 
     *(neugeboren) oder ein zuf�lliges Alter haben.
     *
     * @param zufaelligesAlter soll der Hase ein zuf�lliges Alter haben?
     * @param feld das aktuelle belegte Feld
     * @param position die Position im Feld
     */
    public Hase(boolean zufaelligesAlter, Feld feld, Position position)
    {
        super(feld, position);
        alter = 0;
        if(zufaelligesAlter) {
            alter = rand.nextInt(MAX_ALTER);
        }
    }
    
    /**
     * Das ist was ein Hase die meiste Zeit tut - er l�uft herum.
     * Manchmal geb�rt er Nachwuchs und irgendwann stirbt er
     * an Altersschw�che.
     * @param neueHasen eine Liste zum Zur�ckliefern der neugeborenen Hasen.
     */
    public void agiere(List<Tier> neueHasen)
    {
        alterErhoehen();
        if(istLebendig()) {
            gebaereNachwuchs(neueHasen);
            // nur in das n�chste Feld setzen, wenn eine Position frei ist
            Position neuePosition = gibFeld().freieNachbarposition(gibPosition());
            if(neuePosition != null) {
                setzePosition(neuePosition);
            }
            else {
                // �berpopulation 
                sterben();
            }
        }
    }

    /**
     * Erh�he das Alter. 
     * Dies kann zum Tod des Hasen f�hren.
     */
    private void alterErhoehen()
    {
        alter++;
        if(alter > MAX_ALTER) {
            sterben();
        }
    }
       
    /**
     * Pr�fe, ob dieser Hase in diesem Schritt geb�ren kann.
     * Neugeborene kommen in freie Nachbarpositionen.
     * @param neueHasen eine Liste zum Zur�ckliefern der neugeborenen Hasen.
     */
    private void gebaereNachwuchs(List<Tier> neueHasen)
    {
        // Neugeborene kommen in freie Nachbarpositionen.
        // Freie Nachbarpositionen abfragen.
        Feld feld = gibFeld();
        List<Position> frei = feld.freieNachbarpositionen(gibPosition());
        int geburten = traechtig();
        for(int b = 0; b < geburten && frei.size() > 0; b++) {
            Position pos = frei.remove(0);
            Hase jung = new Hase(false, feld, pos);
            neueHasen.add(jung);
        }
    }

    /**
     * Erzeuge eine Zahl f�r die Wurfgroesse, wenn der Hase
     * gebaeren kann.
     * @return  Wurfgroesse (kann null sein).
     */
    private int traechtig()
    {
        int wurfgroesse = 0;
        if(kannGebaeren() && rand.nextDouble() <= GEBAER_WAHRSCHEINLICHKEIT) {
            wurfgroesse = rand.nextInt(MAX_WURFGROESSE) + 1;
        }
        return wurfgroesse;
    }
    /**
     * Ein Hase kann geb�ren, wenn er das geb�rf�hige
     * Alter erreicht hat.
     */
    private boolean kannGebaeren()
    {
        return alter >= GEBAER_ALTER;
    }
}
