
/**
 * Beschreiben Sie hier die Klasse Automat.
 * 
 * @author Thomas Mittermair
 * @version 7.8.16
 */
public class Automat
{
   private double betragEingeworfen;
   private Produkt produkt1;
   private Produkt produkt2;
   private Produkt produkt3;
   private Produkt produkt4;
   private int anzahlP1;
   private int anzahlP2;
   private int anzahlP3;
   private int anzahlP4;
   private double rueckgeld;
   private int displayAusgabe;
   private Produkt gewuenschtesProdukt;
   
   
   /**
    * Konstruktor der fertige Produkte erwartet
    * 
    * @param produkt1 Fertiges Produkt 1 vom Typ Produkt
    * @param anzahlP1 Anzahl von Produkt 1
    * @param produkt1 Fertiges Produkt 2 vom Typ Produkt
    * @param anzahlP1 Anzahl von Produkt 2
    * @param produkt1 Fertiges Produkt 3 vom Typ Produkt
    * @param anzahlP1 Anzahl von Produkt 3
    * @param produkt1 Fertiges Produkt 4 vom Typ Produkt
    * @param anzahlP1 Anzahl von Produkt 4
    */
   public Automat(Produkt produkt1, Produkt produkt2, Produkt produkt3, Produkt produkt4){
       this.produkt1 = produkt1;
       this.produkt2 = produkt2;
       this.produkt3 = produkt3;
       this.produkt4 = produkt4;
    }
    
    
   /**
    * Konruktor, der die Produkte anhand deren Grunddaten direkt erstellt
    * 
    * @param name1 Name als String von Produkt 1
    * @param preis1 Preis als double von Produkt 1
    * @param tag1 Verfallstag als int von Produkt 1
    * @param monat1 Verfallsmonat als int von Produkt 1
    * @param jahr1 Verfallsjahr als int von Produkt 1
    * @param anzahl1 Anzahl als int von Produkt 1
    * @param name2 Name als String von Produkt 2
    * @param preis2 Preis als double von Produkt 2
    * @param tag2 Verfallstag als int von Produkt 2
    * @param monat2 Verfallsmonat als int von Produkt 2
    * @param jahr2 Verfallsjahr als int von Produkt 2
    * @param anzahl2 Anzahl als int von Produkt 2
    * @param name3 Name als String von Produkt 3
    * @param preis3 Preis als double von Produkt 3
    * @param tag3 Verfallstag als int von Produkt 3
    * @param monat3 Verfallsmonat als int von Produkt 3
    * @param jahr3 Verfallsjahr als int von Produkt 3
    * @param anzahl3 Anzahl als int von Produkt 3
    * @param name4 Name als String von Produkt 4
    * @param preis4 Preis als double von Produkt 4
    * @param tag4 Verfallstag als int von Produkt 4
    * @param monat4 Verfallsmonat als int von Produkt 4
    * @param jahr4 Verfallsjahr als int von Produkt 4
    * @param anzahl4 Anzahl als int von Produkt 4
    */ 
   public Automat(String name1, double preis1, int tag1, int monat1, int jahr1, int anzahl1,
                  String name2, double preis2, int tag2, int monat2, int jahr2, int anzahl2,
                  String name3, double preis3, int tag3, int monat3, int jahr3, int anzahl3,
                  String name4, double preis4, int tag4, int monat4, int jahr4, int anzahl4){
                      this.produkt1 = new Produkt(name1, preis1, anzahl1, tag1, monat1, jahr1);
                      this.produkt2 = new Produkt(name2, preis2, anzahl2, tag2, monat2, jahr2);
                      this.produkt3 = new Produkt(name3, preis3, anzahl3, tag3, monat3, jahr3);
                      this.produkt4 = new Produkt(name4, preis4, anzahl3, tag4, monat4, jahr4);
                    }
   
   /**
    * Geld in Automaten einzahlen
    * 
    * @param betrag Eingezahlter Betrag als double
    */                 
   public void geldEinwerfen(double betrag){
       betragEingeworfen += betrag;
   }
   
   
   /**
    * Gibt aus, wieviel Geld im Automat ist
    */
   public void geldEingeworfen(){
       displayAusgaben(10);
    }
    
   /**
    * Rückgeld auszahlen. Betrag im Automat wird auf 0 gesetzt und das Rückgeld ausbezahlt
    */
   public void rueckgeldAuszahlen(){
       if(betragEingeworfen>0.0){
           rueckgeld = betragEingeworfen;
           betragEingeworfen = 0;
           displayAusgaben(2);
           rueckgeld = 0;
        }
       else displayAusgaben(1);
   }
   
   /**
    * Gibt alle Produkte und deren Anzahl im Display aus
    */
   public void produkteImAutomat(){
       System.out.println("Produkte im Automat:");
       System.out.println("****************************");
       displayAusgaben(3);
       displayAusgaben(4);
       displayAusgaben(5);
       displayAusgaben(6);
   }
   
   /**
    * Kauf ein gewünschtes Produkt
    * 
    * @param name Names des Produkts
    */
   public void produktKaufen(String name){
       if(name.equals(produkt1.getName())) gewuenschtesProdukt = produkt1;
       else if(name.equals(produkt2.getName())) gewuenschtesProdukt = produkt2;
       else if(name.equals(produkt3.getName())) gewuenschtesProdukt = produkt3;
       else if(name.equals(produkt4.getName())) gewuenschtesProdukt = produkt4;
       else {
           displayAusgaben(9);
           return;
        }
           
       if(gewuenschtesProdukt.getAnzahl()>0){
           if(betragEingeworfen>=gewuenschtesProdukt.getPreis()){
               gewuenschtesProdukt.setAnzahl(gewuenschtesProdukt.getAnzahl()-1);
               betragEingeworfen -= gewuenschtesProdukt.getPreis();
               System.out.println(gewuenschtesProdukt.getName() + " gekauft.");
            }
           else displayAusgaben(7);
        }
       else displayAusgaben(8);
    }
   
   /**
    * Diverse Displayausgaben
    * 
    * @param displayAusgabe Nummer der gewünschten Ausgabe
    */
   private void displayAusgaben(int displayAusgabe){
       switch(displayAusgabe){
           //Kein Geld im Automat
           case 1:
           System.out.println("Kein Geld im Automat");
           break;
           //Rückgeld ausgeben
           case 2:
           System.out.println("Rückgeld: " + rueckgeld);
           break;
           //Info Produkt 1
           case 3:
           System.out.println(produkt1.getName());
           System.out.println("Anzahl: " + produkt1.getAnzahl());
           System.out.println("****************************");
           break;
           //Info Produkt 2
           case 4:
           System.out.println(produkt2.getName());
           System.out.println("Anzahl: " + produkt2.getAnzahl());
           System.out.println("****************************");
           break;
           //Info Produkt 3
           case 5:
           System.out.println(produkt3.getName());
           System.out.println("Anzahl: " + produkt3.getAnzahl());
           System.out.println("****************************");
           break;
           //Info Produkt 4
           case 6:
           System.out.println(produkt4.getName());
           System.out.println("Anzahl: " + produkt4.getAnzahl());
           System.out.println("****************************");
           break;
           //Nicht genügend Geld
           case 7:
           System.out.println("Es ist nicht genügend Geld im Automat");
           break;
           //Nicht mehr genug vom gewünschten Getränk im Automat
           case 8:
           System.out.println("Es hat nicht mehr genug " + gewuenschtesProdukt.getName() + " im Automat");
           break;
           //Kein passendes Produkt vorhanden
           case 9:
           System.out.println("Es ist kein passendes Produkt vorhanden");
           break;
           //GeldEingeworfen
           case 10:
           System.out.println("Es hat " + betragEingeworfen + " Franken im Automat");
           break;
        }
          
    }
}
