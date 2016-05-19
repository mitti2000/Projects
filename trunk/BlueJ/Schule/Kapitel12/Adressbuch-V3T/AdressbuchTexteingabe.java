/**
 * Eine textuelle Schnittstelle f�r ein Adressbuch.
 * �ber verschiedene Befehle kann auf das Adressbuch
 * zugegriffen werden.
 *
 * @author David J. Barnes und Michael K�lling.
 * @version 31.07.2011
 */
public class AdressbuchTexteingabe
{
    // Das Adressbuch, das angezeigt und manipuliert werden soll.
    private Adressbuch buch;
    // Ein Parser f�r die Befehlsw�rter.
    private Parser parser;
    
    /**
     * Konstruktor f�r Objekte der Klasse AdressbuchTexteingabe.
     * @param buch das Adressbuch, das manipuliert werden soll.
     */
    public AdressbuchTexteingabe(Adressbuch buch)
    {
        this.buch = buch;
        parser = new Parser();
    }
    
    /**
     * Lies interaktiv Befehle vom Benutzer, die 
     * Interaktionen mit dem Adressbuch erm�glichen.
     * Stoppe, wenn der Benutzer 'ende' eingibt.
     */
    public void starten()
    {
        System.out.println(" -- Adressbuch --");
        System.out.println("Tippen Sie 'hilfe' f�r eine Liste der Befehle.");
        
        String command;
        do{
            command = parser.liefereBefehl();
            if(command.equals("neu")){ 
                neuerEintrag();
            }
            else if(command.equals("gib")){
                gibEintrag();
            }
            else if(command.equals("liste")){
                list();
            }
            else if(command.equals("suche")){
                sucheEintrag();
            }
            else if(command.equals("entferne")){
                entferneEintrag();
            }
            else if(command.equals("hilfe")){
                hilfe();
            }
            else{
                // nichts tun.
            }
        } while(!(command.equals("ende")));

        System.out.println("Ade.");
    }
    
    /**
     * F�ge einen neuen Eintrag hinzu.
     */
    private void neuerEintrag()
    {
        System.out.print("Name: ");
        String name = parser.zeileEinlesen();
        System.out.print("Telefon: ");
        String telefon = parser.zeileEinlesen();
        System.out.print("Adresse: ");
        String adresse = parser.zeileEinlesen();
        buch.neuerKontakt(new Kontakt(name, telefon, adresse));
    }
    
    /**
     * Liefere den Eintrag zu einem Schl�ssel.
     */
    private void gibEintrag()
    {
        System.out.println("Geben Sie einen Schl�ssel des Eintrags an:");
        String schluessel = parser.zeileEinlesen();
        Kontakt ergebnis = buch.gibKontakt(schluessel);
        System.out.println(ergebnis);
    }
    
    /**
     * Entferne einen Eintrag, auf den der Schl�ssel passt.
     */
    private void entferneEintrag()
    {
        System.out.println("Schl�ssel des zu l�schenden Eintrags:");
        String schluessel = parser.zeileEinlesen();
        buch.entferneKontakt(schluessel);
    }
    
    /**
     * Finde Eintr�ge mit passendem Pr�fix.
     */
    private void sucheEintrag()
    {
        System.out.println("Pr�fix des Suchschl�ssels:");
        String praefix = parser.zeileEinlesen();
        Kontakt[] ergebnisse = buch.suche(praefix);
        for(int i = 0; i < ergebnisse.length; i++){
            System.out.println(ergebnisse[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * Zeige die zur Verf�gung stehenden Befehle.
     */
    private void hilfe()
    {
        parser.zeigeBefehle();
    }
    
    /**
     * Gib den Inhalt des Adressbuchs aus.
     */
    private void list()
    {
        System.out.println(buch.alleKontaktdaten());
    }
}
