
public class Animal {
	private int age;
	
	
	public Animal(){
		age = 0;
	}
	
	public int getOlder(int oldAge){
		int newAge = oldAge+1;
		Sheep.setWoolAmount();
		return newAge;
	}
	
	public int getAge(){
		return age;
	}
}
