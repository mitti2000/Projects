package ch.mitti.tuerme;

import java.util.ArrayList;

public class Create {
	
	private Ring ring1;
	private Ring ring3;
	private Ring ring5;
	private Ring ring7;
	private Ring ring9;
	
	private Ring[] pillar1;
	private Ring[] pillar2;
	private Ring[] pillar3;
	
	
	private Draw draw;
	
	
	public Create(){
		ring1 = new Ring(1,1,5);
		ring3 = new Ring(3,1,4);
		ring5 = new Ring(5,1,3);
		ring7 = new Ring(7,1,2);
		ring9 = new Ring(9,1,1);
		
		pillar1 = new Ring[5];
		pillar2 = new Ring[5];
		pillar3 = new Ring[5];
		
		pillar1[0] = ring1;
		pillar1[1] = ring3;
		pillar1[2] = ring5;
		pillar1[3] = ring7;
		pillar1[4] = ring9;
		
		
		draw = new Draw();
		
	}
	
	public void step(){
		boolean fertig = false;
		Ring[] activePillar = null;
		Ring[] targetPillar = null;
		boolean kleinsterRing = true;
		int top1 = 0;
		int top2 = 0;
		int top3 = 0;
		/*
		 * solange (Stab A oder B enthalten Scheiben) {
    		Verschiebe kleinste Scheibe um einen Platz nach rechts
  			Falls eine weitere Scheibe verschiebbar, verschieben
*/
		int summeP1 = 0;
		int summeP2 = 0;
		
		for(int i=0;i<5;i++){
			summeP1+=pillar1[i].getSize();
			summeP2+=pillar2[i].getSize();
		}
		
		while(!fertig){
			if(summeP1>0 || summeP2>0){
				if(kleinsterRing){
					if(ring1.getPosX()==1) activePillar = pillar1;
					else if(ring1.getPosX()==2) activePillar = pillar2;
					else if(ring1.getPosX()==3) activePillar = pillar3;
					
					activePillar[ring1.getPosY()] = null;
					ring1.setPosX(ring1.getPosX()+1);
					
					if(activePillar==pillar1) targetPillar = pillar2;
					else if(activePillar==pillar2) targetPillar = pillar3;
					else if(activePillar==pillar3) targetPillar = pillar1;
					
					for(int i=0; i<5;i++){
						if(targetPillar[i]==null) {
							targetPillar[i] = ring1;
							ring1.setPosY(i+1);
						}
					}
					kleinsterRing = false;
				}
				
				else{
					Ring moveable = null;
					for(int i=0; i<5;i++){
						top1 = pillar1[i].getSize();
						top2 = pillar2[i].getSize();
						top3 = pillar3[i].getSize();
					}
					
					
					
				}
				
			}
			
			else {
				draw.fertig();
				fertig = true;
				break;
			}
			Main.promptEnterKey();
		}
		
	}
	
	public void draw(){
		int[] p1 = new int[5];
		int[] p2 = new int[5];
		int[] p3 = new int[5];
	
		
		for(int i=0; i<5; i++){
			if(pillar1[i]!=null){
				p1[i] = pillar1[i].getSize();
			}
			else p1[i] = 0;
			
			if(pillar2[i]!=null){
				p1[i] = pillar2[i].getSize();
			}
			else p2[i] = 0;
			
			if(pillar3[i]!=null){
				p1[i] = pillar3[i].getSize();
			}
			else p3[i] = 0;
		}
		
		draw.drawPillars(p1,p2,p3);
	}
}
