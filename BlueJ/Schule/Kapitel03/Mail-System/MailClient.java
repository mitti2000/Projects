/**
 * Eine Klasse, die einen einfachen Email-Client modelliert.
 * Ein Client ist einem bestimmten Benutzer zugeordnet und
 * sendet und empf�ngt Nachrichten �ber einen festgelegten Server.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class MailClient
{
    // der Server zum Senden und Empfangen
    private MailServer server;
    // der Benutzer, dem dieser Client zugeordnet ist
    private String benutzer;

    /**
     * Erzeuge einen MailClient f�r den angegebenen Benutzer
     * und verbinde ihn mit dem gegebenen Server.
     * @param server der MailServer f�r diesen Client
     * @param benutzer der Name des Benutzers dieses MailClients.
     */
    public MailClient(MailServer server, String benutzer)
    {
        this.server = server;
        this.benutzer = benutzer;
    }

    /**
     * Liefere die n�chste Nachricht (falls vorhanden)
     * f�r den Benutzer dieses Clients.
     */
    public Nachricht gibNaechsteNachricht()
    {
        return server.gibNaechsteNachrichtFuer(benutzer);
    }

    /**
     * Gib die n�chste Nachricht (falls vorhanden) f�r den
     * Benutzer dieses Clients auf der Konsole aus.
     */
    public void naechsteNachrichtAusgeben()
    {
        Nachricht nachricht = server.gibNaechsteNachrichtFuer(benutzer);
        if(nachricht == null) {
            System.out.println("Keine neue Nachricht.");
        }
        else {
            nachricht.ausgeben();
        }
    }

    /**
     * Sende den gegebenen Nachrichtentext an den angebenen
     * Empf�nger �ber den zugeordneten Mail-Server.
     * @param empfaenger der gew�nschte Empf�nger
     * @param text der Text der Nachricht
     */
    public void sendeNachricht(String empfaenger, String text)
    {
        Nachricht nachricht = new Nachricht(benutzer, empfaenger, text);
        server.leiteWeiter(nachricht);
    }
}
