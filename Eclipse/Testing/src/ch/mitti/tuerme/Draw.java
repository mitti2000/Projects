package ch.mitti.tuerme;

import java.util.ArrayList;

public class Draw {
	private int p1Size;
	private int p2Size;
	private int p3Size;
	
	public Draw(){
		
	}
	
	public void drawPillars(int[] p1, int[] p2, int[] p3){
		System.out.println("*****************************************************************");
		System.out.println("Pillar 1:");
		for(int i1=0; i1<5; i1++){
			p1Size = p1[i1];
			for(int j1=9; j1>=1; j1--){
				if(j1>p1Size) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.print("||");
			for(int k1=1;k1<=9;k1++){
				if(k1<=p1Size) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("====================");
		//****************************************************
		System.out.println("Pillar 2:");
		for(int i2=0; i2<5; i2++){
			p2Size = p2[i2];
			for(int j2=9; j2>=1; j2--){
				if(j2>p2Size) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.print("||");
			for(int k2=1;k2<=9;k2++){
				if(k2<=p2Size) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("====================");
		//****************************************************
		System.out.println("Pillar 3:");
		for(int i3=0; i3<5; i3++){
			p3Size = p3[i3];
			for(int j3=9; j3>=1; j3--){
				if(j3>p2Size) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.print("||");
			for(int k3=1;k3<=9;k3++){
				if(k3<=p3Size) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("====================");
		//****************************************************
		System.out.println("*****************************************************************");
	}
	
	public void fertig(){
		System.out.println("Fertig!!!!");
	}
	
}
