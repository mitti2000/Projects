
/**
 * Beschreiben Sie hier die Klasse Viereck.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Viereck
{
   private Punkt a;
   private Punkt b;
   private Punkt c;
   private Punkt d;
   
   public Viereck(int posX, int posY, int laenge, int breite){
       a = new Punkt(posX, posY);
       b = new Punkt(posX+laenge, posY);
       c = new Punkt(posX, posY+breite);
       d = new Punkt(posX+laenge, posY+breite);
   }
   
   public Viereck(Punkt a, Punkt b, Punkt c, Punkt d){
       this.a = a;
       this.b = b;
       this.c = c;
       this.d = d;
   }
   
   public void verschiebeHorizontal(int wert){
       a.setzeX(a.gibX()+wert);
       b.setzeX(b.gibX()+wert);
       c.setzeX(c.gibX()+wert);
       d.setzeX(d.gibX()+wert);
    }
    
   public void verschiebeVertikal(int wert){
       a.setzeY(a.gibY()+wert);
       b.setzeY(b.gibY()+wert);
       c.setzeY(c.gibY()+wert);
       d.setzeY(d.gibY()+wert);
    }
   
   public void laengeAendern(int wert){
       b.setzeX(b.gibX()+wert);
       d.setzeX(d.gibX()+wert);
    }
    
   public void breiteAendern(int wert){
       c.setzeY(c.gibY()+wert);
       d.setzeY(d.gibY()+wert);
    }
    
   public boolean istQuadrad(){
       if(b.gibX()-a.gibX() == c.gibY()-a.gibY()) return true;
       return false;
    }
}


