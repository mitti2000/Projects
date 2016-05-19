/**
 * Diese Exception h�lt den Schl�ssel, f�r den keine
 * passenden Kontaktdaten im Adressbuch gefunden werden
 * konnten.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 31.07.2011
 */
public class KeinPassenderKontaktException extends Exception
{
    // Der Schl�ssel ohne passende Kontaktdaten.
    private String schluessel;

    /**
     * Speichere Fehlerinformationen.
     * @param schluessel der Schl�ssel ohne passenden Kontakt.
     */
    public KeinPassenderKontaktException(String schluessel)
    {
        this.schluessel = schluessel;
    }

    /**
     * @return den fehlerhaften Schl�ssel.
     */
    public String gibSchluessel()
    {
        return schluessel;
    }
    
    /**
     * @return einen Diagnosetext mit dem fehlerhaften Schl�ssel.
     */
    public String toString()
    {
        return "Keine passender Kontakt f�r '"
                + schluessel + "' gefunden.";
    }
}
