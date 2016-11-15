package ch.mitti.domev1;

public class Main {

	public static void main(String[] args) {
		
		CD cd1 = new CD("Dark side of the moon", "Pink Floyd", 10, 78);
		CD cd2 = new CD("Ignition", "The Offspring", 12, 63);
		DVD dvd1 = new DVD("Ben Hur", "Who Knows?", 1000);
		DVD dvd2 = new DVD("Matrix", "Wachowskys", 59);
		
		Datenbank db = new Datenbank();
		
		db.erfasseDisc(cd1);
		db.erfasseDisc(cd1);
		db.erfasseDisc(dvd1);
		db.erfasseDisc(dvd1);
		
		db.auflisten();
	}

}
