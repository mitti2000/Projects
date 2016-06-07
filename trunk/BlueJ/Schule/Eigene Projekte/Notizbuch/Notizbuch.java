import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Notizbuch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Notizbuch
{
    private ArrayList<Notiz> notizen;
    
    public Notizbuch (){
        notizen = new ArrayList<Notiz>();
    }
    
    public boolean erstelleNotiz(int prioritaet, int tag, int monat, int jahr, String text){
        notizen.add(new Notiz(prioritaet, tag, monat, jahr, text));
        return true;
    }
    
    public int gibAnzahlGespeicherteNotizen(){
        if (notizen.size()>0) return notizen.size();
        else return 0;
    }
    
    public Notiz gibNotizMitNummer(int nummer){
        if(notizen.size()>=nummer) return notizen.get(nummer-1);
        else {
            System.out.println ("Es gibt nur "+notizen.size()+" Notizen.");
            return null;
        }
    }
    
    public void gibAlleNotizenAus(){
        Notiz tempNotiz;
        Iterator it = notizen.iterator();
        if(it.hasNext()){
            while(it.hasNext()){
                tempNotiz = (Notiz) it.next();
                System.out.println("*******************");
                System.out.println("Notiz");
                System.out.println(tempNotiz.getNotizAlsText());
                
            }
        }
        else System.out.println("Keine Notizen vorhanden");
    }
    
}
