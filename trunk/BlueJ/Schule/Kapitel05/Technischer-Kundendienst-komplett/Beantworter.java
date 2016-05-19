import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Die Klasse Beantworter beschreibt Exemplare, die 
 * automatische Antworten in Abh�ngigkeit einer Eingabe
 * generieren. Die Eingabe wird einem Beantworter als 
 * eine Menge von W�rtern �bergeben. Abh�ngig von diesen
 * W�rtern wird ein String als Antwort generiert.
 * 
 * Intern benutzt diese Klasse eine HashMap, um bestimmte
 * Stichw�rter auf Antworten abzubilden, sowie eine Liste
 * von Standardantworten. Wenn eines der W�rter der Eingabe
 * als Stichwort in der HashMap vorkommt, wird die zugeordnete
 * Antwort zur�ckgegeben. Wenn keines der Eingabew�rter erkannt
 * wird, wird aus den Standardantworten zuf�llig eine ausgew�hlt.
 * 
 * @author     Michael K�lling und David J. Barnes
 * @version    1.0 (31.07.2011)
 */
public class Beantworter
{
    // Abbildung von Stichw�rtern auf Antworten.
    private HashMap<String, String> antwortMap;

    // Liste von Standardantworten, falls kein Wort erkannt wird.
    private ArrayList<String> standardantworten;

    private Random zufallsgenerator;

    /**
     * Erzeuge einen Beantworter.
     */
    public Beantworter()
    {
        antwortMap = new HashMap<String, String>();
        standardantworten = new ArrayList<String>();
        antwortMapBefuellen();
        standardantwortlisteFuellen();
        zufallsgenerator = new Random();
    }

    /**
     * Generiere eine Antwort auf eine gegebene Menge von Eingabew�rtern.
     * 
     * @param woerter Eine Menge von W�rtern, die der Benutzer eingegeben hat
     * @return Eine Zeichenkette, die als Antwort geliefert werden soll
     */
    public String generiereAntwort(HashSet<String> woerter)
    {
        for (String wort : woerter) {
            String antwort = antwortMap.get(wort);
            if(antwort != null) {
                return antwort;
            }
        }
        // Wenn wir hierher gelangen, wurde keines der Eingabew�rter erkannt.
        // In diesem Fall w�hlen wir eine unserer Standardantworten (die
        // wir geben, wenn uns nichts Besseres mehr einf�llt).
        
        return standardantwortAusw�hlen();
    }

    /**
     * Trage alle bekannten Stichw�rter mit ihren verkn�pften
     * Antworten in die Map 'antwortMap' ein.
     */
    private void antwortMapBefuellen()
    {
        antwortMap.put("absturz", 
                       "Tja, auf unserem System kommt es nie zu einem Absturz. Das muss \n" +
                       "an Ihrem System liegen. Welche Konfiguration haben Sie?");
        antwortMap.put("abst�rzt", 
                       "Tja, auf unserem System kommt es nie zu einem Absturz. Das muss \n" +
                       "an Ihrem System liegen. Welche Konfiguration haben Sie?");
        antwortMap.put("st�rzt", 
                       "Tja, auf unserem System kommt es nie zu einem Absturz. Das muss \n" +
                       "an Ihrem System liegen. Welche Konfiguration haben Sie?");
        antwortMap.put("langsam", 
                       "Ich vermute, dass das mit Ihrer Hardware zu tun hat. Ein Upgrade\n" +
                       "f�r Ihren Prozessor sollte diese Probleme l�sen. Haben Sie ein\n" +
                       "Problem mit unserer Software?");
        antwortMap.put("performance", 
                       "Bei all unseren Tests war die Performance angemessen. Haben Sie\n" +
                       "andere Prozesse, die im Hintergrund laufen?");
        antwortMap.put("fehler", 
                       "Wissen Sie, jede Software hat Fehler. Aber unsere Entwickler arbeiten\n" +
                       "sehr hart daran, diese Fehler zu beheben. K�nnen Sie das Problem ein\n" +
                       "wenig genauer beschreiben?");
        antwortMap.put("fehlerhaft", 
                       "Wissen Sie, jede Software hat Fehler. Aber unsere Entwickler arbeiten\n" +
                       "sehr hart daran, diese Fehler zu beheben. K�nnen Sie das Problem ein\n" + 
                       "wenig genauer beschreiben?");
        antwortMap.put("windows", 
                       "Das ist ein bekanntes Problem, das im Betriebssystem von Microsoft begr�ndet\n" +
                       "ist. Bitte leiten Sie es an Microsoft weiter. Da k�nnen wir leider nichts \n" +
                       "dran machen.");
        antwortMap.put("macintosh", 
                       "Das ist ein bekanntes Problem, das im Betriebssystem des Mac begr�ndet\n" +
                       "ist. Bitte leiten Sie es an Apple weiter. Da k�nnen wir leider nichts \n" +
                       "dran machen.");
        antwortMap.put("teuer", 
                       "Unsere Preise sind absolute Marktpreise. Haben Sie sich mal umgesehen\n" +
                       "und wirklich unser Leistungsspektrum verglichen?");
        antwortMap.put("installation", 
                       "Die installation ist wirklich sehr einfach. Wir haben haufenweise\n" +
                       "Wizards, die die Arbeit f�r sie erledigen. Haben Sie die Installations-\n" +
                       "anleitung gelesen?");
        antwortMap.put("speicher", 
                       "Wenn sie die Systemanforderungen gr�ndlich lesen, werden Sie feststellen,\n" +
                       "dass die Speicheranforderung 1,5 Gigabyte betr�gt. Sie sollten Ihren\n" +
                       "Hauptspeicher unbedingt aufr�sten. K�nnen wir sonst noch etwas f�r Sie tun?");
        antwortMap.put("linux", 
                       "Wir nehmen Linux sehr ernst. Aber es gibt da einige Probleme.\n" +
                       "Die meisten h�ngen mit der inkompatiblen glibc-Version zusammen. K�nnen \n" +
                       "Sie das Problem etwas pr�ziser beschreiben?");
        antwortMap.put("bluej", 
                       "Ahhh, BlueJ, ja. Wir haben schon vor l�ngerer Zeit versucht, diese Leute \n" +
                       "aufzukaufen, aber sie wollen nicht verkaufen... Sturk�pfe sind das. \n" +
                       "Ich f�rchte, da k�nnen wir nichts dran �ndern.");
    }

    /**
     * Generiere eine Liste von Standardantworten, aus denen wir eine
     * ausw�hlen k�nnen, wenn wir keine bessere Antwort wissen.
     */
    private void standardantwortlisteFuellen()
    {
        standardantworten.add("Das klingt seltsam. K�nnen Sie das Problem ausf�hrlicher beschreiben?");
        standardantworten.add("Bisher hat sich noch kein Kunde dar�ber beschwert. \n" +
                        "Welche Systemkonfiguration haben Sie?");
        standardantworten.add("Das klingt interessant. Erz�hlen Sie mehr...");
        standardantworten.add("Da brauche ich etwas ausf�hrlichere Angaben.");
        standardantworten.add("Haben Sie gepr�ft, ob Sie einen Konflikt mit einer DLL haben?");
        standardantworten.add("Das steht im Handbuch. Haben Sie das Handbuch gelesen?");
        standardantworten.add("Das klingt alles etwas wischi-waschi. Haben Sie einen Experten\n" +
                        "in der N�he, der das etwas pr�ziser beschreiben kann?");
        standardantworten.add("Das ist kein Fehler, das ist eine Systemeigenschaft!");
        standardantworten.add("K�nnten Sie es anders erkl�ren?");
    }

    /**
     * W�hle zuf�llig eine der Standardantworten aus.
     * @return eine zuf�llig gew�hlte Standardantwort.
     */
    private String standardantwortAusw�hlen()
    {
        // Erzeuge eine Zufallszahl, die als Index in der Liste der
        // Standardantworten benutzt werden kann. Die Zahl wird im Bereich
        // von null (inklusiv) bis zur Gr��e der Liste (exklusiv) liegen.
        int index = zufallsgenerator.nextInt(standardantworten.size());
        return standardantworten.get(index);
    }
}
