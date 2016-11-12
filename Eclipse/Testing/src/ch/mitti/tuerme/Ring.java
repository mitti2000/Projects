package ch.mitti.tuerme;

public class Ring {
	
	private int size;
	private int posX;
	private int posY;
	
	
	public Ring(int size, int posX, int posY){
		this.size = size;
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getSize(){
		return size;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}
}
