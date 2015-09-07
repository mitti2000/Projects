package Beatbox;
import javax.sound.midi.*;

public class MusikTest1 {
	public void spielen(){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Wir haben einen Sequencer");
		} catch (MidiUnavailableException ex){
			System.out.println("So ein Mist!");
		}
	}
	
	public static void main(String[] args){
		MusikTest1 mt = new MusikTest1();
		mt.spielen();
		
	}
}
