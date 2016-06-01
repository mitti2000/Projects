
/**
 * Beschreiben Sie hier die Klasse Datum.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Datum
{
   private int tag;
   private int monat;
   private int jahr;
   
   public Datum(int tag, int monat, int jahr){
       this.tag = tag;
       this.monat = monat;
       this.jahr = jahr;
    }
    
   public int getTag(){
       return this.tag;
    }
    
   public int getMonat(){
       return this.monat;
    }
    
   public int getJahr(){
       return this.jahr;
    }
    
   public String gibDatumAlsText(){
       return ""+this.tag+"."+this.monat+"."+this.jahr;
    }
}
