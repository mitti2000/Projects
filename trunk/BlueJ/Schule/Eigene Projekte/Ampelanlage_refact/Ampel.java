
/**
 * Beschreiben Sie hier die Klasse Ampel.
 * 
 * @author Thomas Mittermair
 * @version 1.0
 */
public class Ampel
{
    private Lampe rot;
    private Lampe gelb;
    private Lampe gruen;
    private int status;
    
    public Ampel(){
        status = 3;
        rot = new Lampe();
        gelb = new Lampe();
        gruen = new Lampe();
        rot.lampeAusschalten();
        gelb.lampeAusschalten();
        gruen.lampeEinschalten();
        ausgeben();
    }
    
    public Ampel(boolean start){
        rot = new Lampe();
        gelb = new Lampe();
        gruen = new Lampe();
        
        if(start){
            status = 3;
            rot.lampeAusschalten();
            gelb.lampeAusschalten();
            gruen.lampeEinschalten();
        }
        
        else{
            status = 1;
            rot.lampeEinschalten();
            gelb.lampeAusschalten();
            gruen.lampeAusschalten();
        }
        ausgeben();
    }
    
    public void schalten(){
        status = (status+1) % 5;
        if(status==0) status++;
        switch(status){
            case 1:
                rot.lampeEinschalten();
                gelb.lampeAusschalten();
                gruen.lampeAusschalten();
                break;
            case 2:
                rot.lampeEinschalten();
                gelb.lampeEinschalten();
                gruen.lampeAusschalten();
                break;
            case 3:
                rot.lampeAusschalten();
                gelb.lampeAusschalten();
                gruen.lampeEinschalten();
                break;
            case 4:
                rot.lampeAusschalten();
                gelb.lampeEinschalten();
                gruen.lampeAusschalten();
                break;
            }
        ausgeben();
    }
    
    public void ausgeben(){
        if(rot.gibZustand()) System.out.println("O");
        else System.out.println(".");
        
        if(gelb.gibZustand()) System.out.println("O");
        else System.out.println(".");
        
        if(gruen.gibZustand()) System.out.println("O");
        else System.out.println(".");
        
        System.out.println("---");
    }
}
