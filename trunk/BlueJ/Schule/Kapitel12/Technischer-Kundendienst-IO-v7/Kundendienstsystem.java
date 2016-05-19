import java.util.HashSet;

/**
 * Diese Klasse implementiert ein System f�r einen technischen
 * Kundendienst. Das System kommuniziert mit dem Benutzer �ber 
 * die Konsole.
 * 
 * Diese Klasse benutzt ein Exemplar der Klasse Eingabeleser, 
 * um Eingaben vom Benutzer zu lesen, und ein Exemplar der
 * Klasse Beantworter, um Antworten zu generieren.
 * In einer Schleife werden so lange Eingaben eingelesen und
 * Antworten auf diese Eingaben generiert, bis der Benutzer
 * das System verl�sst.
 * 
 * @author     David J. Barnes und Michael K�lling  
 * @version    1.0
 */
public class Kundendienstsystem
{
    private Eingabeleser leser;
    private Beantworter beantworter;
    
    /**
     * Erzeuge ein Kundendienstsystem.
     */
    public Kundendienstsystem()
    {
        leser = new Eingabeleser();
        beantworter = new Beantworter();
    }

    /**
     * Starte das System f�r den technischen Kundendienst.
     * Es wird ein Begr��ungstext ausgegeben und anschlie�end
     * eine Dialog mit dem Benutzer gef�hrt, bis der Benutzer
     * den Dialog beendet.
     */
    public void starten()
    {
        boolean fertig = false;

        willkommenstextAusgeben();

        while(!fertig) {
            HashSet<String> eingabe = leser.gibEingabe();

            if(eingabe.contains("ade")) {
                fertig = true;
            }
            else {
                String antwort = beantworter.generiereAntwort(eingabe);
                System.out.println(antwort);
            }
        }
        abschiedstextAusgeben();
    }

    /**
     * Gib einen Willkommenstext auf der Konsole aus.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println("Willkommen beim technischen Kundendienst" +
                           " der Firma SeltsamSoft.");
        System.out.println();
        System.out.println("Bitte schildern Sie uns Ihr Problem.");
        System.out.println("Wir werden Sie bestm�glich unterst�tzen.");
        System.out.println("Bitte tippen Sie 'ade', um unser System zu" +
                           " verlassen.");    }

    /**
     * Gib einen Abschiedstext auf der Konsole aus.
     */
    private void abschiedstextAusgeben()
    {
        System.out.println("Vielen Dank f�r das Gespr�ch. Ade...");
    }
}
