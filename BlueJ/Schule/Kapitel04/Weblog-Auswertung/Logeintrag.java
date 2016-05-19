import java.util.Calendar;

/**
 * Ein Logeintrag repr�sentiert die Daten einer
 * Zeile in der Logdatei eines Webservers.
 * Die einzelnen Werte werden �ber sondierende
 * Operationen wie gibStunde() und gibMinute()
 * verf�gbar gemacht.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 31.07.2011
 */
public class Logeintrag implements Comparable<Logeintrag>
{
    // Array, in dem die Werte einer Logzeile gehalten werden
    private int[] logzeilenwerte;
    // das �quivalente Calendar-Objekt f�r die Zeit der Eintragung
    private Calendar wann;
    
    // welcher Index liefert welchen Wert aus der Zeile
    private static final int JAHR = 0, MONAT = 1, TAG = 2,
                             STUNDE = 3, MINUTE = 4;
    // Die Anzahl der Felder. Wenn weitere Felder hinzugef�gt werden, beispielsweise f�r
    // Sekunden oder einen Statuscode, muss dieser Wert entsprechend erh�ht werden.
    private static final int ANZAHL_FELDER = 5;
                      
    /**
     * Zerteile eine Logzeile so, dass die einzelnen
     * Werte verf�gbar werden.
     * @param logzeile eine einzelne Zeile aus der Logdatei.
               Die Zeile sollte folgendes Format haben:
               jahr monat tag stunde minute etc.
     */
    public Logeintrag(String logzeile)
    {
        // das Array f�r die Werte einer Zeile anlegen
        logzeilenwerte = new int[ANZAHL_FELDER];
        // die Werte aus der Zeile auslesen
        LogdateiZeilenzerleger scanner = new LogdateiZeilenzerleger();
        scanner.zerlegen(logzeile,logzeilenwerte);
        setzeWann();
    }
    
    /**
     * Erzeuge aus den einzelnen Komponenten einen Logeintrag
     * @param jahr das Jahr
     * @param monat der Monat (1-12)
     * @param tag der Tag (1-31)
     * @param stunde die Stunde (0-23)
     * @param minute die Minute (0-59)
     * @return den Stunden-Wert eines Logeintrags.
     */
    public Logeintrag(int jahr, int monat, int tag, int stunde, int minute)
    {
        // das Array f�r die Werte einer Zeile anlegen
        logzeilenwerte = new int[ANZAHL_FELDER];
        logzeilenwerte[JAHR] = jahr;
        logzeilenwerte[MONAT] = monat;
        logzeilenwerte[TAG] = tag;
        logzeilenwerte[STUNDE] = stunde;
        logzeilenwerte[MINUTE] = minute;
        setzeWann();
    }
    
    /**
     * Liefere die Stunde.
     * @return den Stunden-Wert eines Logeintrags.
     */
    public int gibStunde()
    {
        return logzeilenwerte[STUNDE];
    }

    /**
     * Liefere die Minute.
     * @return den Minuten-Wert eines Logeintrags.
     */
    public int gibMinute()
    {
        return logzeilenwerte[MINUTE];
    }
    
    /**
     * Erzeuge eine Repr�sentation als String.
     * Das Ergebnis ist nicht notwendigerweise
     * identisch mit der urspr�nglichen Logzeile.
     *
     * @return eine Zeichenkette, die die Werte 
     *          der Logzeile enth�lt.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int wert : logzeilenwerte) {
            // bei einstelligen Werten eine f�hrende
            // Null einf�gen
            if(wert < 10) {
                buffer.append('0');
            }
            buffer.append(wert);
            buffer.append(' ');
        }
        // anh�ngende Leerzeichen abschneiden
        return buffer.toString().trim();
    }
    
    /**
     * Vergleiche die Datums- und Zeitwerte dieses Eintrags
     * mit denen eines anderen.
     * @param andererEintrag der andere Eintrag, mit dem verglichen werden soll.
     * @return Einen negativen Wert, wenn dieser Eintrag einen fr�heren
     *          Zeitpunkt repr�sentiert. Einen positiven Wert, wenn
     *          dieser Eintrag einen sp�teren Zeitpunkt repr�sentiert.
     *          Null, wenn beide Eintr�ge den gleichen Zeitpunkt
     *          repr�sentieren.
     */
    public int compareTo(Logeintrag andererEintrag)
    {
        // Verwende die zugeh�rige Calendar-Vergleichsmethode.
        return wann.compareTo(andererEintrag.gibWann());
    }
    
    /**
     * Liefere das Calendar-Objekt, welches das Ereignis repr�sentiert
     * @return Das Calendar-Objekt f�r dieses Ereignis.
     */
    private Calendar gibWann()
    {
        return wann;
    }

    /**
     * Erzeuge ein zu den Werten passendes Calendar-Objekt.
     */
    private void setzeWann()
    {
        wann = Calendar.getInstance();
        // Wandle die 1-basierten Werte f�r Monat und Jahr in 0-basierte Werte um.
        wann.set(logzeilenwerte[JAHR],
                 logzeilenwerte[MONAT] - 1, logzeilenwerte[TAG] - 1,
                 logzeilenwerte[STUNDE], logzeilenwerte[MINUTE]);
    }    
}