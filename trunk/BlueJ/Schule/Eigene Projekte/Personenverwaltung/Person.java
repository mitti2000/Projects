
/**
 * Beschreiben Sie hier die Klasse Person.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Person
{
    private String vorname;
    private String nachname;
    private int alter;
    private String telefonnummer;
    private String mobilnummer;
    
    public Person(String vorname, String nachname, int alter, String telefonnummer, String mobilnummer){
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.telefonnummer = telefonnummer;
        this.mobilnummer = mobilnummer;
    }
    
    public String getVorname(){
        return vorname;
    }
    
    public String getNachname(){
        return nachname;
    }
    
    public int getAlter(){
        return alter;
    }
    
    public String getTelefonnummer(){
        return telefonnummer;
    }
    
    public String getMobilnummer(){
        return mobilnummer;
    }
    
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname){
        this.nachname = nachname;
    }
    
    public void setAlter(int alter){
        this.alter = alter;
    }
    
    public void setTelefonnummer(String telefonnumer){
        this.telefonnummer = telefonnummer;
    }
    
    public void setMobilnummer(String mobilnummer){
        this.mobilnummer = mobilnummer;
    }
    
    public String gibPersonAlsString(){
        return "Name:" +vorname + ", Nachname:" + nachname + ", Alter:" + alter + ", Telefonnummer:" + telefonnummer + ", Mobilnummer:" + mobilnummer;
    }
    
    public boolean equals(Person p){
        if(this.vorname.equals(p.vorname) &&
        this.nachname.equals(p.nachname) &&
        this.alter==p.alter &&
        this.mobilnummer.equals(p.mobilnummer) &&
        this.telefonnummer.equals(p.telefonnummer) )
        {
            return true;
        }
        return false;
    }
}
