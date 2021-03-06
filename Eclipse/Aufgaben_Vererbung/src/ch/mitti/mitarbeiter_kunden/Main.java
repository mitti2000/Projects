package ch.mitti.mitarbeiter_kunden;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> personen = new ArrayList<Person>();
		
		personen.add(new Mitarbeiter("Hans", "M�ller", 53, 5836, 80, 5300));
		personen.add(new Mitarbeiter("Fritz", "Meier", 38, 5736, 100, 6300));
		personen.add(new Lehrling("Felix", "Fleixon", 15, 2, 4));
		personen.add(new Chef("Max", "Power", 42, 5, "GL"));
		personen.add(new Kunde("Fehr", "Braunwalder", 2, 'A'));
		personen.add(new Kunde("Bill", "Gates", 1, 'E'));
		
		Iterator<Person> it = personen.iterator();
		while(it.hasNext()){
			System.out.println(it.next().datenAusgeben());
			
		}
	}

}
