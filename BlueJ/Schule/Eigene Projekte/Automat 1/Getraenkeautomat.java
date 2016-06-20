
/**
 * Ein Getränkeautomat mit 4 initalen Getränken. Es können weitere Getränke hinzugefügt werden.
 * Durch einzahlen von Geld können Getränke gekauft werden und das Restgeld ausbezahlt werden.
 * 
 * @author Thomas Mittermair 
 * @version 19.5.16
 */

import java.util.ArrayList; //Zur Nutzung von ArrayList

public class Getraenkeautomat
{
    private float geldEingeworfen;
    private ArrayList<String> getraenke;
    private ArrayList<Float> preise;
    private ArrayList<Integer> anzahl;
    
    /**
     * Konstruktor - Kein Parameter nötig
     */
    public Getraenkeautomat(){
        geldEingeworfen = 0.0f;
        getraenke = new ArrayList<String>();
        preise = new ArrayList<Float>();
        anzahl = new ArrayList<Integer>();
        getraenkHinzufuegen("Cola", 2.6f, 10);
        getraenkHinzufuegen("Red Bull", 3.6f, 10);
        getraenkHinzufuegen("Wasser", 1.0f, 10);
        getraenkHinzufuegen("Bier", 5.2f, 10);
    }
    
    /**
     * Gibt den Preis des gewünschten Getränks zurück
     * @param name Name des Getränks als String
     */
    public void gibPreis(String name){
        
        for (int i=0; i<getraenke.size(); i++){
            if(name.equals(getraenke.get(i))){
                System.out.println("Preis von " + name + " ist " + preise.get(i));
                return;
            }
        }
        System.out.println("Kein passendes Getränk gefunden");
    }
    
    /**
     * Fügt dem Automaten Geld zu
     * @param betrag Geldbetrag als float
     */
    public void geldEinwerfen(float betrag){
        geldEingeworfen += betrag;
    }
    
    public float geldEingeworfen(){
        return geldEingeworfen;
    }
    
    /**
     * Gibt das Retourgeld zurück und setzt den Betrag im Automaten auf 0
     * @return Rückgeld als float
     */
    public float rueckgeldAuszahlen(){
        float rueckgeld = geldEingeworfen;
        geldEingeworfen = 0;
        return rueckgeld;
    }
    
    /**
     * Gibt die restliche Anzahl eine Getränks zurück
     * @return Anzahl als int
     * @param name Name des gewünschten Getränks als String
     */
    public int anzahlProdukt(String name){
        for (int i=0;i<getraenke.size();i++){
            if(name.equals(getraenke.get(i))){
                return anzahl.get(i);
            }
        }
        return 0;
    }
    
    /**
     * Getränk kaufen
     * Gewüschtes Getränk wird aus dem Automaten abgezogen. Der Geldbetrag im Automaten wird um den Preis des Getränks reduziert
     * @param name Name des gewünschten Getränks als String
     */
    public void getraenkKaufen(String name){
        int anzahlTemp = 0;
        for(int i=0;i<getraenke.size();i++){
            if(name.equals(getraenke.get(i))){
                if (geldEingeworfen >= preise.get(i)){
                    if (anzahl.get(i)>0){
                        anzahlTemp = anzahl.get(i);
                        anzahlTemp--;
                        anzahl.add(i, anzahlTemp);
                        System.out.println(getraenke.get(i) + " gekauft. Prost!");
                        geldEingeworfen -= preise.get(i);
                        System.out.println("Restbetrag im Automat ist " + geldEingeworfen);
                        if (anzahl.get(i)==0) System.out.println("Es hat kein "+getraenke.get(i)+" mehr.");
                        return;
                    }
                    else {
                        System.out.println("Es hat kein "+getraenke.get(i)+" mehr.");
                        return;
                    }
                }
                else {
                    System.out.println("Es ist nicht genügend Geld eingeworfen!");
                    System.out.println("Fehlender Betrag: " + (preise.get(i) - geldEingeworfen));
                }
            }
        }
        System.out.println("Kein passendes Getränk gefunden");
    }
    
    /**
     * Neues Getränk hinzufügen
     * @param name Name des Getränks als String
     * @param preis Preis des Getränks als float
     * @param menge Menge des Getränks als int
     */
    public void getraenkHinzufuegen(String name, float preis, int menge){
        if(name != null && preis >= 0.0 && menge > -1){
            getraenke.add(name);
            preise.add(preis);
            anzahl.add(menge);
            getraenkeInfo(name);
            return;
        }
        System.out.println("Fehler. Kein Getränk hinzugefügt!");
    }
    
    /**
     * Getränkeinfo ausgeben. Gibt Name, Preis und Anzahl eines gewünschten Getränks in die Konsole aus
     * @param name Name des Getränks als String
     */
    public void getraenkeInfo(String name){
        if(name != null){
            for(int i=0; i<getraenke.size();i++){
                if(name.equals(getraenke.get(i))){
                    System.out.println(getraenke.get(i));
                    System.out.println(preise.get(i));
                    System.out.println(anzahl.get(i));
                    return;
                }
            }
        }
        else System.out.println("Kein Getränk mit dem Namen " + name + " vorhanden!");
    }
                
}
