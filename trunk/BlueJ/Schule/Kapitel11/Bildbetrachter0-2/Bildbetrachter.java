import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * Bildbetrachter ist die Hauptklasse der Bildbetrachter-Anwendung. Sie
 * erstellt die GUI der Anwendung, zeigt sie an und initialisiert alle
 * anderen Komponenten.
 * 
 * Erzeugen Sie ein Exemplar dieser Klasse, um die Anwendung zu starten.
 * 
 * @author Michael K�lling und David J Barnes 
 * @version 0.2
 */
public class Bildbetrachter
    implements ActionListener
{
    private JFrame fenster;
    
    /**
     * Erzeuge einen Bildbetrachter und zeige seine GUI auf
     * dem Bildschirm an.
     */
    public Bildbetrachter()
    {
        fensterErzeugen();
    }

    /**
     * Empfange die Benachrichtigung �ber eine Aktion.
     * @param event die Details der Aktion.
     */
    public void actionPerformed(ActionEvent event) 
    { 
        System.out.println("Men�eintrag: " + event.getActionCommand());
    }

    
    
    // ---- Swing-Anteil zum Erzeugen des Fensters mit allen Komponenten ----
    
    /**
     * Erzeuge das Swing-Fenster samt Inhalt.
     */
    private void fensterErzeugen()
    {
        fenster = new JFrame("Bildbetrachter");
        menuezeileErzeugen(fenster);
        
        Container contentPane = fenster.getContentPane();
        
        JLabel label = new JLabel("Ich bin ein Label. Ich kann Text anzeigen.");
        contentPane.add(label);

        // Aufbau abgeschlossen - Komponenten arrangieren lassen
        fenster.pack();
        fenster.setVisible(true);
    }
    
    /**
     * Die Men�zeile des Hauptfensters erzeugen.
     * @param fenster das Fenster, in das die Men�zeile eingef�gt werden soll.
     */
    private void menuezeileErzeugen(JFrame fenster)
    {
        JMenuBar menuezeile = new JMenuBar();
        fenster.setJMenuBar(menuezeile);
                
        // Das Datei-Men� erzeugen
        JMenu dateiMenue = new JMenu("Datei");
        menuezeile.add(dateiMenue);
        
        JMenuItem oeffnenEintrag = new JMenuItem("�ffnen");
        oeffnenEintrag.addActionListener(this);
        dateiMenue.add(oeffnenEintrag);

        JMenuItem beendenEintrag = new JMenuItem("Beenden");
        beendenEintrag.addActionListener(this);
        dateiMenue.add(beendenEintrag);

    }
}
