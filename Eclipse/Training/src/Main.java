
public class Main {
	static int woolSave = 0;
			
	public static void main( String[] args ) {
		//Create Objects
		Sheep sheep1 = new Sheep("Toni");
		Sheep sheep2 = new Sheep("Kurt");
		
		//Set variables for age and name
		int age1 = sheep1.getAge();
		int age2 = sheep2.getAge();
		String name1 = sheep1.getName();
		String name2 = sheep2.getName();
		
		//Make sheep 1 older
		age1 = sheep1.getOlder(age1);
		
		//print out names and age
		System.out.println("Alter " + name1 + ": " + age1);
		System.out.println("Alter " + name2 + ": " + age2);
		System.out.println("Gespeicherte Wolle" + woolSave);
		System.out.println("");
		System.out.println("Scheren " + name1);
		woolSave =  sheep1.shear(woolSave);
		System.out.println("Gespeicherte Wolle " + woolSave);
		System.out.println("Scheren " + name2);
		woolSave +=  sheep2.shear(woolSave);
		System.out.println("Gespeicherte Wolle " + woolSave);
		System.out.println("");
		System.out.println("warten");
		System.out.println("Zeit vergeht");
		System.out.println("und alles wird �lter");
		age1 = sheep1.getOlder(age1);
		age2 = sheep2.getOlder(age2);
		System.out.println("");
		System.out.println("Alter " + name1 + ": " + age1);
		System.out.println("Alter " + name2 + ": " + age2);
		System.out.println("");
		System.out.println("Scheren " + name1);
		woolSave +=  sheep1.shear(woolSave);
		System.out.println("Gespeicherte Wolle " + woolSave);
		System.out.println("Scheren " + name2);
		woolSave +=  sheep2.shear(woolSave);
		System.out.println("Gespeicherte Wolle " + woolSave);
	  }
}