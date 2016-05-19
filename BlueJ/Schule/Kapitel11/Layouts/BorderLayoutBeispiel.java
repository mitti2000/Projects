import java.awt.*;
import javax.swing.*;

/**
 * Demonstriert das BorderLayout.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class BorderLayoutBeispiel
{
    private JFrame fenster;

    /**
     * Konstruktor f�r Objekte der Klasse BorderLayoutBeispiel
     */
    public BorderLayoutBeispiel()
    {
        fensterErzeugen();
    }

    /**
     * F�ge f�nf Komponenten in die verf�gbaren Positionen ein.
     */
    private void fensterErzeugen()
    {
        fenster = new JFrame("BorderLayout-Beispiel");
        
        Container contentPane = fenster.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JButton("Norden"), BorderLayout.NORTH);
        contentPane.add(new JButton("S�den"), BorderLayout.SOUTH);
        contentPane.add(new JButton("Mitte"), BorderLayout.CENTER);
        contentPane.add(new JButton("Westen"), BorderLayout.WEST);
        contentPane.add(new JButton("Osten"), BorderLayout.EAST);
        
        fenster.pack();
        fenster.setVisible(true);
    }
}
