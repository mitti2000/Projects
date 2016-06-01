
/**
 * Beschreiben Sie hier die Klasse Notizbuch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Notizbuch
{
    private ArrayList<Notiz> notizen;
    
    public boolean erstelleNotiz(int prioritaet, int tag, int monat, int jahr, String text){
        notizen = new ArrayList<Notiz>;
        notizen.add(new Notiz(prioritaet, tag, monat, jahr, text));
        return true;
    }
    
    public int gibAnzahlGespeicherteNotizen(){
        return notizen.size();
    }
    
    public Notiz gibNotizMitNummer(int nummer){
        return notizen.get(nummer-1);
    }
    
    public void gibAlleNotizenAus(){
        Notiz tempNotiz;
        Interator it = notizen.iterator();
        while(it.hasNext(){
            tempNotiz = it.next();
            System.out.println("*******************");
            System.out.println("Notiz");
            System.out.println("Prioritaet: "+tempNotiz.gibPrioritaet());
            System.out.println("Datum: "+temp.
        }
    }
    
}
