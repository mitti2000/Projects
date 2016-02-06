
public class Sheep extends Animal {
	static int woolAmount; //wool amount in grams
	private String name="";
	
	public Sheep(String name) {
		woolAmount = 300;
		setName(name);
	}
	
	public void setName(String newName){
		name=newName;
	}
	
	public String getName(){
		return name;
	}
	
	public static void setWoolAmount(){
		woolAmount = 300;
	}
	
	public int shear(int shearedAmount){
		shearedAmount+=woolAmount;
		System.out.println(woolAmount);
		woolAmount = 0;
		return shearedAmount;
	}
}
