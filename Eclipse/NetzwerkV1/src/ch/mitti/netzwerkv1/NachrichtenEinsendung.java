package ch.mitti.netzwerkv1;

/**
 * Diese Klasse speichert Informationen �ber eine Einsendung innerhalb eines sozialen
 * Netzwerks. Der Hauptteil der Einsendung besteht aus einer (m�glicherweise 
 * mehrzeiligen) Textnachricht. Weitere Daten, wie Autor und Datum, werden ebenfalls 
 * gespeichert.
 * 
 * @author Michael K�lling und David J. Barnes
 * @version 0.1
 */
public class NachrichtenEinsendung extends Einsendung
{
    private String nachricht;     // eine beliebig lange, mehrzeilige Nachricht


    /**
     * Konstruktor f�r Objekte der Klasse NachrichtenEinsendung.
     * 
     * @param autor    der Benutzername des Einsenders.
     * @param text      der Text dieser Einsendung.
     */
    public NachrichtenEinsendung(String autor, String text)
    {
    	super(autor);
        nachricht = text;
    }


    /**
     * Liefere den Text dieser Einsendung.
     * 
     * @return den Text der Einsendung.
     */
    public String gibText()
    {
        return nachricht;
    }

    @Override
    public void anzeigen()
    {
    	System.out.println(nachricht);
    	super.anzeigen();
        
    }
  
    
}
