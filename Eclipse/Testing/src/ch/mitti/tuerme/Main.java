package ch.mitti.tuerme;
import java.util.Scanner; 

public class Main {
	
	
	

	public static void main(String[] args) {		
		Create create = new Create();
		System.out.println("T�rme von Hanoi");
		System.out.println();
		create.draw();
		System.out.println("N�chster Schritt? (Press any key");
		promptEnterKey();
	}
	
	static void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}

}
