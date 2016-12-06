package ch.mitti.geometrische_figuren;

import java.awt.geom.*; //Alle Klassen des Geometrie-Pakets

public class Ellipse extends Figur {
    // Attribute
    private int radius1; 
    private int radius2; 

    
    // Konstruktor
    public Ellipse() {
    	super(50,50,"magenta");
        this.radius1=15;
        this.radius2=40;
        this.draw();
    }
    
    public Ellipse(int xPosition, int yPosition, int radius1, int radius2, String color) {
    	super(xPosition, yPosition, color);
        this.radius1=radius1;
        this.radius2=radius2;
        this.draw();
    }

    // Dienste
    public void draw(){ //mit private und public ausprobieren
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, super.getColor(), "Ellipse", new Ellipse2D.Double(super.getxPosition(), super.getyPosition(), radius1, radius2));
    }

}
