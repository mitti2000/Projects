
/**
 * Beschreiben Sie hier die Klasse Ampel.
 * 
 * @author Thomas Mittermair
 * @version 1.0
 */
public class Ampel
{
    private boolean rot;
    private boolean gelb;
    private boolean gruen;
    private int status;
    
    public Ampel(){
        status = 3;
        rot = false;
        gelb = false;
        gruen = true;
        ausgeben();
    }
    
    public Ampel(boolean start){
        if(start){
            status = 3;
            rot = false;
            gelb = false;
            gruen = true;
        }
        
        else{
            status = 1;
            rot = true;
            gelb = false;
            gruen = false;
        }
        ausgeben();
    }
    
    public void schalten(){
        if(status<4)status++;
        else if (status==4) status=1;
        switch(status){
            case 1:
                rot=true;
                gelb=false;
                gruen=false;
                break;
            case 2:
                rot=true;
                gelb=true;
                gruen=false;
                break;
            case 3:
                rot=false;
                gelb=false;
                gruen=true;
                break;
            case 4:
                rot=false;
                gelb=true;
                gruen=false;
                break;
            }
        ausgeben();
    }
    
    public void ausgeben(){
        if(rot) System.out.println("O");
        else System.out.println(".");
        
        if(gelb) System.out.println("O");
        else System.out.println(".");
        
        if(gruen) System.out.println("O");
        else System.out.println(".");
        
        System.out.println("---");
    }
}
