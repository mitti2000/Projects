package ch.mitti.geometrische_figuren;

import java.awt.*; //Alle Klasse des Abstrakt Window Toolkit

public class Rechteck extends Figur{
    // Attribute
    private int width; //Deklaration des Attributs width, also Breite
    private int height; //H�he des Rechtecks
    
    // Konstruktor
    public Rechteck() {
    	super(50,50,"red");
        width=50;
        height=20;
        draw();
    }
    
    public Rechteck(int xPosition, int yPosition, int width, int height, String color) {
        this.width=width;
        this.height=height;
        this.draw();
    }
    
    // Dienste
    public void draw(){ //mit private und public ausprobieren
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, super.getColor(), "Rectangle", new Rectangle(super.getxPosition(), super.getyPosition(), width, height));
    }

}
