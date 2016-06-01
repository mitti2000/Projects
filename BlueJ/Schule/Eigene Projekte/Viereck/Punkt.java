
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkt
{
    private int posX;
    private int posY;
    
    public Punkt(int x, int y){
        posX = x;
        posY = y;
    }
    
    public void setzeX(int wert){
        posX = wert;
    }
    
    public void setzeY (int wert){
        posY = wert;
    }
    
    public int gibX(){
        return posX;
    }
    
    public int gibY(){
        return posY;
    }
}
