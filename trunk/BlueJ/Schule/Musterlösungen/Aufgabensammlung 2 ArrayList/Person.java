/**
 * Diese Klasse verwaltet Informationen über eine Person
 * wie Vorname, Nachname, Alter, Telefon- sowie Mobiltelefonnummer
 * 
 * @author Alexander Palmer
 * @version 23.06.2015
 */
public class Person
{
    private String vorname;
    private String nachname;
    private int alter;
    private String telefonnummer;
    private String mobiltelefonnummer;
    
    /**
     * Initialisiert alle Datenfelder mittels Parameter
     */
    public Person(String vorname, String nachname, int alter,
                    String telefonnummer, String mobiltelefonnummer)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.telefonnummer = telefonnummer;
        this.mobiltelefonnummer = mobiltelefonnummer;
    }
    
    /**
     * Liefert den Vornamen einer Person
     * @return Vorname einer Person
     */
    public String gibVorname()
    {
        return this.vorname;
    }
    
    /** 
     * Liefert den Nachnamen einer Person
     * @return Nachname einer Person
     */
    public String gibNachname()
    {
        return this.nachname;
    }
    
    /**
     * Liefert das Alter einer Person
     * @return Alter einer Person
     */
    public int gibAlter()
    {
        return this.alter;
    }
    
    /** 
     * Liefert die Telefonnummer einer Person
     * @reurn Telefonnummer einer Person
     */
    public String gibTelefonnummer()
    {
        return this.telefonnummer;
    }
    
    /** 
     * Liefert die Mobiltelefonnummer einer Person
     * @return Mobiltelefonnummer einer Person
     */
    public String gibMobiltelefonnummer()
    {
        return this.mobiltelefonnummer;
    }
    
    /** 
     * Liefert alle Attribute einer Person in einem String
     * @return Alle Attribute einer Person als String
     */
    public String gibPersonAlsString()
    {
        return vorname + ", " + nachname + ", " + alter +
            ", " + telefonnummer + ", " + mobiltelefonnummer;
    }
}