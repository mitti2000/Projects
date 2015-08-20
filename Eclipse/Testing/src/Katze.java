
public class Katze extends Tier implements Haustier{
	
	public Katze (String name, int alter){
		this.name = name;
		this.alter = alter;
		tierart = "Katze";
	}

	@Override
	public void lässtSichStreicheln(){
		System.out.println("Schnurr");
	}
	
	@Override
	public void lauf() {
		System.out.println("Die " + tierart + " mit dem Namen " + name + " läuft elegant");
		
	}

	@Override
	public void gibLaut() {
		System.out.println("Die " + tierart + " mit dem Namen " + name + " mach Miau");
		
	}
	

}
