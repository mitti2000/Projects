package Beatbox;

import java.awt.*;
import java.util.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;

public class Beatbox {
	JPanel hauptpanel;
	ArrayList<JCheckBox> checkboxListe;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame derFrame;
	
	String[] instrumentenNamen ={"Bassdrum", "Hi-Hat, geschlossen", "Hi-Hat, offen", "Snaredrum",
			"Crashbecken", "H�ndeklatschen", "Hohes Tom-Tom", "Hohes Bongo", "Maracas", "Trillerpfeife", 
			"Tiefe Conga", "Kuhglocke", "Vibraslap", "Tieferes Tom-Tom", "Hohes Agogo", "Hohe Conga, offen"};
	int[] intrumente = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main (String[] args){
		new Beatbox().guiErstellen();
	}
	
	public void guiErstellen(){
		derFrame = new JFrame("CyberBeatBox");
		derFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel hintergrund = new JPanel(layout);
		hintergrund.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		checkboxListe = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Starten");
		start.addActionListener(new MeinStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stoppen");
		stop.addActionListener(new MeinStopListener());
		buttonBox.add(stop);
		
		JButton schneller = new JButton("Schneller");
		schneller.addActionListener(new MeinSchnellerListener());
		buttonBox.add(schneller);
		
		JButton langsamer = new JButton("Langsamer");
		langsamer.addActionListener(new MeinLangsamerListener());
		buttonBox.add(langsamer);
		
		JButton l�schen = new JButton("L�schen");
		l�schen.addActionListener(new MeinL�schenListener());
		buttonBox.add(l�schen);
		
		JButton speichern = new JButton("Speichern");
		speichern.addActionListener(new MeinSendenListener());
		buttonBox.add(speichern);
		
		JButton laden = new JButton("Laden");
		laden.addActionListener(new MeinEinlesenListener());
		buttonBox.add(laden);
		
		GridLayout namensGrid = new GridLayout(16,1);
		namensGrid.setVgap(1);
		JPanel namensBox2 = new JPanel(namensGrid);
				
		
		for(int i=0; i<16;i++){
			namensBox2.add(new JLabel(instrumentenNamen[i]));
		}
		
		hintergrund.add(BorderLayout.EAST, buttonBox);
		hintergrund.add(BorderLayout.WEST, namensBox2);
		
		derFrame.getContentPane().add(hintergrund);
		
		GridLayout raster = new GridLayout(16,16);
		raster.setVgap(1);
		raster.setHgap(2);
		hauptpanel = new JPanel(raster);
		hintergrund.add(BorderLayout.CENTER, hauptpanel);
		
		for (int i =0; i<256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxListe.add(c);
			hauptpanel.add(c);
		}
		
		midiEinrichten();
		
		derFrame.setBounds(50,50,300,300);
		derFrame.pack();
		derFrame.setVisible(true);
	}
	
	public void midiEinrichten(){
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch (Exception e){e.printStackTrace();}
	}
	
	public void trackErstellenUndStarten(){
		int[] trackListe = null;
		
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for (int i=0;i<16;i++){
			trackListe= new int[16];
			int taste = intrumente[i];
			
			for(int j=0;j<16;j++){
				JCheckBox jc = checkboxListe.get(j + (16*i));
				if(jc.isSelected()){
					trackListe[j] =taste;
				} else{
					trackListe[j] = 0;
				}
			}
			tracksErzeugen(trackListe);
		}
		
		track.add(eventErzeugen(192,9,1,0,16));
		try{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e){e.printStackTrace();}
	}
	
	public class MeinStartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			trackErstellenUndStarten();			
		}
	}
	
	public class MeinStopListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			sequencer.stop();		
		}
	}
	
	public class MeinSchnellerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	}
	
	public class MeinLangsamerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * .97));	
		}
	}
	
	public class MeinL�schenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(int i=0; i<256; i++){
				JCheckBox cb = checkboxListe.get(i);
				cb.setSelected(false);
			}
		}
	}
	
	public class MeinSendenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			File file = null;
			//String[] fileName =new String[2];
			String filePath ="";
			boolean[] checkboxZustand = new boolean[256];
			for(int i=0; i<256;i++){
				JCheckBox check = (JCheckBox) checkboxListe.get(i);
				if(check.isSelected()) checkboxZustand[i]=true;
			}
			
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser", "ser");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				file = chooser.getSelectedFile();
				filePath = file.getAbsolutePath();
				String[] fileName = filePath.split("\\.");
				System.out.println(filePath);

				try{
					FileOutputStream fileStream = new FileOutputStream(new File(fileName[0] + ".ser"));
					ObjectOutputStream os =  new ObjectOutputStream(fileStream);
					os.writeObject(checkboxZustand);
				} catch (Exception ex) {
					ex.printStackTrace();
					}
			}
			
			
		}
	}
	
	public class MeinEinlesenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean[] checkboxZustand = null;
			File file = null;
			String filePath = "";
			
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser", "ser");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				file = chooser.getSelectedFile();
				filePath = file.getAbsolutePath();
			}
			try{
				FileInputStream fileIn = new FileInputStream(new File(filePath));
				ObjectInputStream is =  new ObjectInputStream(fileIn);
				checkboxZustand = (boolean[]) is.readObject();
			} catch (Exception ex) {ex.printStackTrace();}
			
			for(int i=0; i<256;i++){
				JCheckBox check = (JCheckBox) checkboxListe.get(i);
				if(checkboxZustand[i]) check.setSelected(true);
				else check.setSelected(false);
			}
			
			sequencer.stop();
		}
	}
	
	public void tracksErzeugen(int[] liste){
		for(int i=0;i<16;i++){
			int taste = liste[i];
			
			if(taste != 0){
				track.add(eventErzeugen(144,9,taste,100,i));
				track.add(eventErzeugen(128,9,taste,100,i+1));
			}
		}
	}
	
	public MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e){e.printStackTrace();}
		return event;
	}

}