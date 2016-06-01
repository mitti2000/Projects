
/**
 * Beschreiben Sie hier die Klasse Notiz.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Notiz
{
    private int prioritaet;
    private Datum datum;
    private String text;
    
    public Notiz(int prioritaet, int tag, int monat, int jahr, String text){
        this.prioritaet = prioritaet;
        this.text = text;
        datum = new Datum(tag, monat, jahr);
    }
    
    public int getPrioritaet(){
        return this.prioritaet;
    }
    
    public Datum getDatum(){
        return this.datum;
    }
    
    public String getText(){
        return this.text;
    }
    
    public String gibNotizAlsText(){
        String notiz=null;
        notiz += "Prioritaet: " + this.prioritaet;
        notiz += ", Datum: " + this.datum.gibDatumAlsText();
        notiz += ", Text: "+ this.text;
        
        return notiz;
    }
}
