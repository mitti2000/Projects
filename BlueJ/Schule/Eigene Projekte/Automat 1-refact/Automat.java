
/**
 * Beschreiben Sie hier die Klasse Automat.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Automat
{
    private float geldEingeworfen;
    private ArrayList<Produkt> produkte;
    
    public Automat(){
        geldEingeworfen = 0.0f;
        produkte = new ArrayList<Produkt>();
    }
    
    public void produktHinzu(int anzahl, String name, float preis, int tag, int monat, int jahr){
        if (anzahl>0){
            for(int i=anzahl-1; i>=0; i--){
                produkte.add(new Produkt(name, preis, tag, monat, jahr));
            }
        }
        else System.out.println("Keine Getränke hinzugefügt");
    }
    
    public void geldEinwerfen(float betrag){
        this.geldEingeworfen += betrag;
    }
    
    public float betragImAutomat(){
        return geldEingeworfen;
    }
    
    public float rueckgeldAuszahlen(){
        float rueckgeld = geldEingeworfen;
        geldEingeworfen = 0.0f;
        return rueckgeld;
    }
    
    public int anzahlProdukt(String name){
        int anzahl = 0;
        Iterator<Produkt> it = produkte.iterator();
        while(it.hasNext()){
            Produkt tempProdukt =  it.next();
            if(tempProdukt.gibName().equals(name)){
                anzahl++;
            }
        }
        
        return anzahl;
    }
    
    public void produktKaufen(String name){
        Iterator<Produkt> it = produkte.iterator();
        while(it.hasNext()){
            Produkt tempProdukt = it.next();
            if(tempProdukt.gibName().equals(name)){
                if(tempProdukt.gibPreis() <= geldEingeworfen){
                    geldEingeworfen -= tempProdukt.gibPreis();
                    System.out.println(tempProdukt.gibName() + " gekauft.");
                    it.remove();
                    break;
                }
                else {
                    System.out.println("Nicht genug Geld");
                    break;
                }
            }
        }
    }
    
    
}
