/**
 * Diese Klasse definiert ein einfaches Bild. Um das Bild auf
 * dem Bildschirm anzeigen zu lassen, muss die zeichne-Operation auf
 * einem Exemplar aufgerufen werden.
 * Aber hier steckt mehr drin: Da es eine elektronische Zeichnung ist,
 * kann sie geändert werden. Man kann sie schwarz-weiß anzeigen lassen
 * und dann wieder in Farbe (nachdem sie gezeichnet wurde, ist ja klar).
 * 
 * Diese Klasse ist als frühes Java-Lehrbeispiel mit BlueJ gedacht.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 31.07.2011
 */
public class Bild
{
    private Quadrat wand;
    private Quadrat fenster;
    private Dreieck dach;
    private Kreis sonne;

    /**
     * Erzeuge ein Exemplar der Klasse Bild
     */
    public Bild()
    {
        // nichts zu tun hier, alle Exemplarvariablen werden automatisch
        // mit null initialisiert.
    }

    /**
     * Zeichne das Bild.
     */
    public void zeichne()
    {
        wand = new Quadrat();
        wand.horizontalBewegen(-140);
        wand.vertikalBewegen(20);
        wand.groesseAendern(120);
        wand.sichtbarMachen();
        
        fenster = new Quadrat();
        fenster.farbeAendern("schwarz");
        fenster.horizontalBewegen(-120);
        fenster.vertikalBewegen(40);
        fenster.groesseAendern(40);
        fenster.sichtbarMachen();

        dach = new Dreieck();  
        dach.groesseAendern(60, 180);
        dach.horizontalBewegen(20);
        dach.vertikalBewegen(-60);
        dach.sichtbarMachen();

        sonne = new Kreis();
        sonne.farbeAendern("gelb");
        sonne.horizontalBewegen(100);
        sonne.vertikalBewegen(-40);
        sonne.groesseAendern(80);
        sonne.sichtbarMachen();
        
        sonne.langsamUntergehen(300);
        sonne.langsamAufgehen();
    }

    /**
     * Ändere die Darstellung in schwarz-weiß.
     */
    public void inSchwarzWeissAendern()
    {
        if(wand != null)   // nur wenn schon gezeichnet wurde ...
        {
            wand.farbeAendern("schwarz");
            fenster.farbeAendern("weiss");
            dach.farbeAendern("schwarz");
            sonne.farbeAendern("schwarz");
        }
    }

    /**
     * Ändere die Darstellung in Farbe.
     */
    public void inFarbeAendern()
    {
        if(wand != null)   // nur wenn schon gezeichnet wurde ...
        {
            wand.farbeAendern("rot");
            fenster.farbeAendern("schwarz");
            dach.farbeAendern("gruen");
            sonne.farbeAendern("gelb");
        }
    }
}
