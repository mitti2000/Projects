
/**
 * Beschreiben Sie hier die Klasse Freunde.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.*;

public class Freunde
{
    private ArrayList<String> meineFreunde;
    
    public Freunde(){
        meineFreunde = new ArrayList<String>();
    }
    
    public void hinzufügen(String name){
        meineFreunde.add(name);
    }
    
    public String gibName(int position){
        if(position<meineFreunde.size()-1&&position>=0) return meineFreunde.get(position);
        else return ("Index passt nicht");
    }
    
    public int gibAnzahlFreunde(){
        return meineFreunde.size();
    }
    
    public void loescheFreund(int position){
        if(position<meineFreunde.size()-1&&position>=0) meineFreunde.remove(position);
        else System.out.println("Index passt nicht");
    }
    
    public void alleNamenAusgeben(){
        for(String n:meineFreunde){
            System.out.println(n);
        }
    }
    
    public boolean sucheFreund(String name){
        for(String n:meineFreunde){
            if(n==name) return true;
        }
        return false;
    }
    
    public int gibPosition(String name){
        for(int i=0;i<meineFreunde.size();i++){
            if(meineFreunde.get(i)==name) return i;
        }
        return -1;
    }
    
    
}
