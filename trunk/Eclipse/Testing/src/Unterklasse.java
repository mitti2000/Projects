
public class Unterklasse extends Mittelklasse{
	public Unterklasse(){
		super("HeyHo");
		System.out.println("Unterklasse");
	}
	
	public void Test() throws Exception{
		throw new Exception();
	}
}
