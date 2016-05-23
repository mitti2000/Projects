
/**
 * Write a description of class Wochenlohprogramm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wochenlohnprogramm
{
    private String name;
    private double stundenansatz;
    private double sollZeit;
    private double faktorUeberzeit;
    private double faktorWochenende;
    private int wochentag;
    private double[] tagesZeit;
    private double[] ueberZeit;
    private double gesamtZeit;
    private double gesamtVerdienst;
    private int gearbeiteteTage;
        
    public Wochenlohnprogramm(String name, double stundenansatz, double sollZeit, double faktorUeberzeit, double faktorWochenende){
        this.name = name;
        this.stundenansatz = stundenansatz;
        this.sollZeit = sollZeit;
        this.faktorUeberzeit = faktorUeberzeit;
        this.faktorWochenende = faktorWochenende;
        wochentag=7;
        tagesZeit = new double[7];
        ueberZeit = new double[7];
    }
    
    public void neuerTag(double stunden){
        if(stunden>=0){        
            if (wochentag==7) wochentag = 1;
            else if (wochentag<7 && wochentag>0) wochentag++;
            
            if(wochentag>=1 && wochentag<=5){
                if(stunden>sollZeit) tagesZeit[wochentag-1]=stunden + ((stunden-sollZeit)*faktorUeberzeit);
                else tagesZeit[wochentag-1] = stunden;
            }
            
            if (wochentag==6 || wochentag==7){
                if(stunden>sollZeit) tagesZeit[wochentag-1]=(stunden + ((stunden-sollZeit)*faktorUeberzeit))*faktorWochenende;
                else tagesZeit[wochentag-1] = stunden*faktorWochenende;
            }
            
            if(stunden>sollZeit) ueberZeit[wochentag-1]=stunden-sollZeit;
            else if(stunden < sollZeit) ueberZeit[wochentag-1]=0;
        }
        else System.out.println("Zeit unter 0!!");
    }
    
    public void stundenblatt(){
        System.out.println("**********************************************************");
        System.out.println("***       Stundenblatt für " + name + ".");
        System.out.println("**********************************************************");
        System.out.println("Montag:     gearbeitet:"+tagesZeit[0]+" davon Überzeit:"+(ueberZeit[0])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[0]*stundenansatz));
        System.out.println("Dienstag:   gearbeitet:"+tagesZeit[1]+" davon Überzeit:"+(ueberZeit[1])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[1]*stundenansatz));
        System.out.println("Mittwoch:   gearbeitet:"+tagesZeit[2]+" davon Überzeit:"+(ueberZeit[2])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[2]*stundenansatz));
        System.out.println("Donnerstag: gearbeitet:"+tagesZeit[3]+" davon Überzeit:"+(ueberZeit[3])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[3]*stundenansatz));
        System.out.println("Freitag:    gearbeitet:"+tagesZeit[4]+" davon Überzeit:"+(ueberZeit[4])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[4]*stundenansatz));
        System.out.println("Samstag:    gearbeitet:"+tagesZeit[5]+" davon Überzeit:"+(ueberZeit[5])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[5]*stundenansatz));
        System.out.println("Sonntag:    gearbeitet:"+tagesZeit[6]+" davon Überzeit:"+(ueberZeit[6])+" ergibt einen Tagesverdienst von CHF"+(tagesZeit[6]*stundenansatz));
        System.out.println("**********************************************************");
        for(int i=0; i<7;i++){
            gesamtZeit += tagesZeit[i];
            gesamtVerdienst += tagesZeit[i]*stundenansatz;
            if(tagesZeit[i]>0.0) gearbeiteteTage++;
        }
        
        System.out.println("Total gearbeitet:" + gesamtZeit + " Stunden. Durchschnitt pro gearbeiteter Tag:"+ (gesamtZeit/gearbeiteteTage) + " Stunden. Gesamtverdienst:CHF " + (gesamtZeit*stundenansatz)); 
    }
}
