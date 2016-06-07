
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    
   int kicks;
   Ball ball;
   public Spieler(Ball b){
       this.ball = b;
    }
    
   public void spieleBallAnSpieler(Spieler s){
       if(s==this) System.out.println("Ichh kann ja nicht gut gegen mich selbst spielen")
       else if(
       else{
           s.nimmBall(ball);
           ball = null;
           kicks++;
        }
   }
    
   public void nimmBall(Ball b){
     this.ball = b;  
    }
    
   public void gibBall(Spieler s){
    
    }
}
