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
 * @version 0.4
 */
public class Bildbetrachter
{
    // Datenfelder
    private JFrame fenster;
    private Bildflaeche bildflaeche;
    
    /**
     * Erzeuge einen Bildbetrachter und zeige seine GUI auf
     * dem Bildschirm an.
     */
    public Bildbetrachter()
    {
        fensterErzeugen();
    }


    // ---- Implementierung der Men�-Funktionen ----
    
    /**
     * 'Datei oeffnen'-Funktion: �ffnet einen Dateiauswahldialog zur 
     * Auswahl einer Bilddatei und zeigt das selektierte Bild an.
     */
    private void dateiOeffnen()
    {
        Farbbild bild = BilddateiManager.gibBild();
        bildflaeche.setzeBild(bild);
        fenster.pack();
    }
        
    /**
     * 'Beenden'-Funktion: Beendet die Anwendung.
     */
    private void beenden()
    {
        System.exit(0);
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
        
        bildflaeche = new Bildflaeche();
        contentPane.add(bildflaeche);

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
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menuezeile = new JMenuBar();
        fenster.setJMenuBar(menuezeile);
                
        // Das Datei-Men� erzeugen
        JMenu dateiMenue = new JMenu("Datei");
        menuezeile.add(dateiMenue);
        
        JMenuItem oeffnenEintrag = new JMenuItem("�ffnen...");
            oeffnenEintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            oeffnenEintrag.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { dateiOeffnen(); }
                           });
        dateiMenue.add(oeffnenEintrag);

        JMenuItem beendenEintrag = new JMenuItem("Beenden");
            beendenEintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            beendenEintrag.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { beenden(); }
                           });
        dateiMenue.add(beendenEintrag);

    }
}
