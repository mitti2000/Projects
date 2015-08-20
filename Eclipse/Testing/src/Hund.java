
public class Hund extends Tier{
	
	public Hund(String name, int alter){
		this.name = name;
		this.alter = alter;
		tierart="Hund";
	}
	@Override
	void lauf() {
		System.out.println("Der " + tierart + " mit dem Namen " + name + " läuft schnell");
		
	}

	@Override
	void gibLaut() {
		System.out.println("Der " + tierart + " mit dem Namen " + name + " macht WauWau");
	}
}
