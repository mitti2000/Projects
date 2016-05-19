import java.awt.Color;

/**
 * Ein Bildfilter f�r einen Grobrastereffekt, wie bei einem
 * vergr��erten Digitalbild mit niedriger Aufl�sung.
 * 
 * @author Michael K�lling und David J Barnes 
 * @version 1.0
 */
public class Grobrasterfilter extends Filter
{
    /**
     * Konstruktor f�r Objekte der Klasse Grobrasterfilter
     * @param name der Name des Filters.
     */
    public Grobrasterfilter(String name)
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
        final int RASTERGROESSE = 5;
        int breite = bild.getWidth();
        int hoehe = bild.getHeight();
        
        for(int y = 0; y < hoehe; y+=RASTERGROESSE) {
            for(int x = 0; x < breite; x+=RASTERGROESSE) {
                Color farbe = bild.gibPunktfarbe(x, y);
                for(int dy = y; dy < y+RASTERGROESSE; dy++) {
                    for(int dx = x; dx < x+RASTERGROESSE; dx++) {
                        if( dx < breite && dy < hoehe )
                            bild.setzePunktfarbe(dx, dy, farbe);
                    }
                }
            }
        }
    }
}
