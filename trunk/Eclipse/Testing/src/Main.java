
public class Main {

	public static void main(String[] args) {
		String[] hundeNamen = {"Fido", "Rex", "Kuddel", "Schn�gi"};
		String[] katzenNamen = {"Nacho", "Chulo", "Excalibur", "Bebe"};
		Hund[] hund = new Hund[4];
		Katze[] katze = new Katze[4];
		
		for (int i=0; i<4; i++){
			hund[i]=new Hund(hundeNamen[i], 25);
			katze[i]=new Katze(katzenNamen[i], 25);
			
			hund[i].lauf();
			hund[i].gibLaut();
			
			
			katze[i].lauf();
			katze[i].gibLaut();
			katze[i].l�sstSichStreicheln();
			
		}
		

	}
	

}