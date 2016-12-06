package ch.mitti.geometrische_figuren;

import java.awt.*; //Alle Klasse des Abstrakt Window Toolkit

public class Quadrat extends Figur{
    // Attribute
    private int size; 
    
    // Konstruktor
    public Quadrat() {
    	super(150,50,"yellow");
        this.size=50;
        this.draw();
    }
        
    public Quadrat(int xPosition, int yPosition, int size, String color) {
    	super(xPosition, yPosition, color);
        this.size=size;
        this.draw();
    }

    // Dienste
    public void draw(){
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, super.getColor(), "Square", new Rectangle(super.getxPosition(), super.getyPosition(), size, size));
    }

}