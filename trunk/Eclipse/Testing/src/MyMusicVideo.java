import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;

public class MyMusicVideo{
	
	static JFrame f = new JFrame("Mein Musikvideo");
	static MeinZeichenPanel ml;
	
	public static void main (String[] args){
		MyMusicVideo myMusicVideo = new MyMusicVideo();
		myMusicVideo.los();
	}
	
	public void guiErstellen(){
		ml= new MeinZeichenPanel();
		f.setContentPane(ml);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void los(){
		
		guiErstellen();
		
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[]{127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r=0;
			
			for (int i=0; i<120; i++){
				r =(int)((Math.random()*50)+1);
				track.add(eventErzeugen(144, 1, r,100,i));
				track.add(eventErzeugen(176, 1, 127, 0,i));
				track.add(eventErzeugen(128, 1, r, 100, i+2));
			}
			sequencer.setSequence(seq);
			sequencer.start();
			Thread.sleep(5000);
			sequencer.close();
			sequencer.setTempoInBPM(220);			
			
		} catch (Exception  ex) {ex.printStackTrace();}
	}
	
	
	
	public static MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e){}
	return event;
	}



	
	class MeinZeichenPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;

		@Override
		public void controlChange(ShortMessage event) {
			msg = true; 
			repaint();
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2d = (Graphics2D) g;
				
				int r = (int) (Math.random()*250);
				int gr = (int) (Math.random()*250);
				int b = (int) (Math.random()*250);
				
				g.setColor(new Color(r,gr,b));
				
				int höhe = (int) ((Math.random()*120) + 10);
				int breite = (int) ((Math.random()*120) + 10);
				int x = (int) ((Math.random()* 40)+10);
				int y = (int) ((Math.random()* 40)+10);
				
				g.fillRect(x, y, breite, höhe);
				msg= false;
			}
		}
	}
	
	

}
