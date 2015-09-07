import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class GUITest{
	
	public static void main (String[] args){
		GUITest guiTest = new GUITest();
		guiTest.los();
	}
	
	public void los(){
		drawGUI();
	}
	
	public void drawGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton button1 = new JButton("Text nummer 1");
		JButton button2 = new JButton("Text nummer 2");
		JButton button3 = new JButton("Text nummer 3");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(250, 200);
		frame.setVisible(true);
		
	}
	
}


