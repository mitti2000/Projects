import java.awt.Color;

/**
 * Ein Bildfilter f�r einen Solarisationseffekt.
 * 
 * @author Michael K�lling und David J Barnes 
 * @version 1.0
 */
public class Solarisationsfilter extends Filter
{
    /**
     * Konstruktor f�r Objekte der Klasse Solarisationsfilter
     * @param name der Name des Filters.
     */
    public Solarisationsfilter(String name)
    {
        super(name);
    }

    /**
     * Wende diesen Filter auf das gegebene Bild an.
     * 
     * @param  bild  das Bild, das dieser Filter ver�ndern soll.
     */
    public void anwenden(Farbbild bild)
    {
        int hoehe = bild.getHeight();
        int breite = bild.getWidth();
        for(int y = 0; y < hoehe; y++) {
            for(int x = 0; x < breite; x++) {
                Color farbe = bild.gibPunktfarbe(x, y);
                int rot = farbe.getRed();
                if(rot <= 127) {
                    rot = 255 - rot;
                }
                int gruen = farbe.getGreen();
                if(gruen <= 127) {
                    gruen = 255 - gruen;
                }
                int blau = farbe.getBlue();
                if(blau <= 127) {
                    blau = 255 - blau;
                }
                bild.setzePunktfarbe(x, y, new Color(rot, gruen, blau));
            }
        }
    }

}
