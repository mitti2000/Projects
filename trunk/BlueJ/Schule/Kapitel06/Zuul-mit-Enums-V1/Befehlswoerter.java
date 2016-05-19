import java.util.HashMap;

/**
 * Diese Klasse h�lt eine Aufz�hlung aller Befehlsw�rter, die dem
 * Spiel bekannt sind. Mit ihrer Hilfe werden eingetippte Befehle
 * erkannt.
 *
 * @author  Michael K�lling und David J. Barnes
 * @version 31.07.2011
 */

class Befehlswoerter
{
    // eine Abbildung von Befehlsw�rtern auf Elemente des 
    // Aufz�hlungstyps Befehlswort
    private HashMap<String, Befehlswort> gueltigeBefehle;

    /**
     * Konstruktor - initialisiere die Befehlsw�rter.
     */
    public Befehlswoerter()
    {
        gueltigeBefehle = new HashMap<String, Befehlswort>();
        gueltigeBefehle.put("go", Befehlswort.GO);
        gueltigeBefehle.put("help", Befehlswort.HELP);
        gueltigeBefehle.put("quit", Befehlswort.QUIT);        
    }

    
    /**
     * Finde das Befehlswort, das mit einem Befehls-String verkn�pft ist.
     * @param befehlswort das nachzuschlagende Wort (als String)
     * @return Das zugeh�rige Befehlswort zum dem Wort oder UNKNOWN,
     *         wenn das Wort kein g�ltiges Befehlswort ist.
     */
    public Befehlswort gibBefehlswort(String wort)
    {
        Befehlswort befehlswort = gueltigeBefehle.get(wort);
        if(befehlswort != null) {
            return befehlswort;
        }
        else {
            return Befehlswort.UNKNOWN;
        }
    }
        
    /**
     * Pr�fe, ob eine gegebene Zeichenkette ein g�ltiger
     * Befehl ist.
     * @return 'true', wenn die gegebene Zeichenkette ein g�ltiger
     * Befehl ist, 'false' sonst.
     */
    public boolean istBefehl(String eingabe)
    {
        return gueltigeBefehle.containsKey(eingabe);
    }

    /**
     * Gib alle g�ltigen Befehlsw�rter auf die Konsole aus.
     */
    public void alleAusgeben() 
    {
        for(String befehl : gueltigeBefehle.keySet()) {
            System.out.print(befehl + "  ");
        }
        System.out.println();
    }
}
