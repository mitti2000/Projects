package ch.mitti.auktion;

public class Main {

	public static void main(String[] args) {
		Auktion auktionsHaus = new Auktion();
		Person meier = new Person("Herr Meier");
		Person gans = new Person("Frau Gans");
		Person auktionator = new Person("Auktionator");
		
		auktionsHaus.postenAnmelden("Goldene Uhr");
		auktionsHaus.postenAnmelden("Silbernes Huhn");
		auktionsHaus.postenAnmelden("Bronzener Kugelschreiber");
		
		auktionsHaus.gibGebotAb(1, auktionator, 0);
		auktionsHaus.gibGebotAb(2, auktionator, 0);
		auktionsHaus.gibGebotAb(3, auktionator, 0);
		
		System.out.println("---Auktion ist eröffnet---");
		System.out.println("");
		System.out.println("---" + gans.gibName() + " gibt Gebot ab---");
		System.out.println("");
		auktionsHaus.gibGebotAb(1, gans, 10100);
		

		System.out.println("---" + meier.gibName() + " gibt Gebot ab---");
		System.out.println("");
		auktionsHaus.gibGebotAb(1, meier, 10200);
		
		auktionsHaus.gibGebotAb(1, gans, 11111);
		System.out.println(auktionsHaus.gibPosten(1) + " geht an " + gans.gibName());
		auktionsHaus.gibGebotAb(3, meier, 222);
		System.out.println(auktionsHaus.gibPosten(3) + " geht an " + meier.gibName());
		
	}

}
