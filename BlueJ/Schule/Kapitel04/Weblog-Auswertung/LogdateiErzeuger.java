import java.io.*;
import java.util.*;

/**
 * Eine Klasse zum Erzeugen von Logdatei mit zuf�lligen Daten.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 31.07.2011
 */
public class LogdateiErzeuger
{
    private Random zufallsgenerator;

    /**
     * Erzeuge Logdateien.
     */
    public LogdateiErzeuger()
    {
        zufallsgenerator = new Random();
    }
    
    /**
     * Erzeuge eine Datei mit zuf�lligen Logeintr�gen.
     * @param dateiname die Datei, in die geschrieben werden soll.
     * @param anzahlEintraege wie viele Eintr�ge.
     * @return true wenn erfolgreich, ansonsten false .
     */
    public boolean erzeugeDatei(String dateiname, int anzahlEintraege)
    {
        boolean erfolg = false;
        
        if(anzahlEintraege > 0) {
            try {
                FileWriter writer = new FileWriter(dateiname);
                Logeintrag[] eintraege = new Logeintrag[anzahlEintraege];
                for(int i = 0; i < anzahlEintraege; i++) {
                    eintraege[i] = erzeugeEintrag();
                }
                Arrays.sort(eintraege);
                for(int i = 0; i < anzahlEintraege; i++) {
                    writer.write(eintraege[i].toString());
                    writer.write('\n');
                }
                
                writer.close();
                erfolg = true;
            }
            catch(IOException e) {
                System.err.println("Es gab ein Problem beim Schreiben in " + dateiname);
            }
                
        }
        return erfolg;
    }
    
    /**
     * Erzeuge einen einzelnen (zuf�lligen) Eintrag f�r eine Logdatei.
     * @return Ein Logeintrag mit zuf�lligen Daten.
     */
    public Logeintrag erzeugeEintrag()
    {
        int jahr = 2011;
        int monat = 1 + zufallsgenerator.nextInt(12);
        // umgehe die Komplexit�t einer exakten Tage-im-Monat-Berechnung
        int tag = 1 + zufallsgenerator.nextInt(28);
        int stunde = zufallsgenerator.nextInt(24);
        int minute = zufallsgenerator.nextInt(60);
        return new Logeintrag(jahr, monat, tag, stunde, minute);
    }

}
