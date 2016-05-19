import java.awt.*;
import javax.swing.*;

/**
 * Demonstriert das FlowLayout.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 31.07.2011
 */
public class FlowLayoutBeispiel
{
    private JFrame fenster;

    /**
     * Konstruktor f�r Objekte der Klasse FlowLayoutBeispiel
     */
    public FlowLayoutBeispiel()
    {
        fensterErzeugen();
    }

    /**
     * F�ge f�nf Komponenten in einen Container ein, der seinen Inhalt
     * mit einem FlowLayout verwaltet.
     */
    private void fensterErzeugen()
    {
        fenster = new JFrame("FlowLayout-Beispiel");
        
        Container contentPane = fenster.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("Erster"));
        contentPane.add(new JButton("Zweiter"));
        contentPane.add(new JButton("Der dritte String ist lang"));
        contentPane.add(new JButton("Vierter"));
        contentPane.add(new JButton("F�nfter"));
        
        fenster.pack();
        fenster.setVisible(true);
    }
}
