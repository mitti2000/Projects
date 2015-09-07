package Beatbox;

import javax.sound.midi.*;

public class MiniMiniMusicProg {
	public static void main(String[] args){
		MiniMiniMusicProg mini = new MiniMiniMusicProg();
		
		int instrument = 126;
		int ton = 40;
		mini.spielen(instrument, ton);
		
	}
	
	public void spielen(int instrument, int ton){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			ShortMessage first = new ShortMessage();
			first.setMessage (192, 1, instrument, 0);
			MidiEvent instrumentWechsel = new MidiEvent(first,1);
			track.add(instrumentWechsel);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, ton, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, ton, 100);
			MidiEvent noteOff = new MidiEvent(b, 10);
			track.add(noteOff);
			
			player.setSequence(seq);
			System.out.println("jetzt");
			player.start();
			Thread.sleep(5000);
			player.close();
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
