package ch.mitti.netzwerkv1;

/**
 * Diese Klasse speichert Informationen �ber eine Einsendung innerhalb eines sozialen 
 * Netzwerks. Der Hauptteil der Einsendung besteht aus einem Foto und einer �berschrift. 
 * Weitere Daten, wie Autor und Datum, werden ebenfalls gespeichert.
 * 
 * @author Michael K�lling und David J. Barnes
 * @version 0.1
 */
public class FotoEinsendung extends Einsendung
{
    private String dateiname;     // der Name der Bilddatei
    private String ueberschrift;  // einzeilige Bild�berschrift

    /**
     * Konstruktor f�r Objekte der Klasse FotoEinsendung.
     * 
     * @param autor          der Benutzername des Einsenders.
     * @param dateiname      der Dateiname des Bildes in dieser Einsendung.
     * @param ueberschrift   eine �berschrift f�r das Bild.
     */
    public FotoEinsendung(String autor, String dateiname, String ueberschrift)
    {
    	super(autor);
        this.dateiname = dateiname;
        this.ueberschrift = ueberschrift;
    }


    /**
     * Liefere den Dateinamen des Bildes aus der Einsendung.
     * 
     * @return den Namen der Bilddatei.
     */
    public String gibBilddateiname()
    {
        return dateiname;
    }

    /**
     * Liefere die �berschrift des Bildes aus der Einsendung.
     * 
     * @return die �berschrift des Bildes.
     */
    public String gibUeberschrift()
    {
        return ueberschrift;
    }

    /**
     * Zeige die Details der Einsendung an.
     * 
     * (Aktuell werden die Daten auf die Konsole ausgegeben, wodurch momentan die 
     * Anzeige im Webbrowser simuliert werden soll.)
     */
    
    @Override
    public void anzeigen()
    {
    	System.out.println("[" + dateiname + "]");
        System.out.println(ueberschrift);
        super.anzeigen();
        
       
    }
    
}
