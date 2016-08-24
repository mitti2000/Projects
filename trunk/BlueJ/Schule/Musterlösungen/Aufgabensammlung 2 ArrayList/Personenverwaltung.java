import java.util.ArrayList;
/**
 * Verwaltet Objektreferenzen des Typs Person in einer Sammlung
 * und bietet verschiedene Methoden an, diese Sammlung zu
 * verwalten.
 * 
 * @author Alexander Palmer
 * @version 23.06.2015
 */
public class Personenverwaltung {
    // Die Sammlung, welche den generischen Typ <Person> definiert
    // In dieser Sammlung können also nur Referenzen des Typs
    // Person verwaltet werden
    private ArrayList<Person> personen;

    /**
     * Initialisiert die Sammlung, indem diese instantiiert wird
     */
    public Personenverwaltung() {
        personen = new ArrayList<Person>();
    }

    /**
     * Fügt eine Objektreferenz des Typs Person der Sammlung hinzu
     * @param p Erwartet Objektreferenz des Typs Person
     * @return Liefert true, wenn das Hinzufügen geklappt hat, ansonsten false
     */
    public boolean hinzufuegen(Person p) {
        // Hier wird geprüft, ob kein null-Wert via Parameter übergeben wurde
        if(p!=null) {
            return personen.add(p);
        }
        return false;
    }

    /**
     * Fügt eine Objektreferenz des Typs Person an der Spitze 
     * der Sammlung hinzu (also Index 0). 
     * @param p Erwartet Objektreferenz des Typs Person
     * @return Liefert true, wenn das Hinzufügen geklappt hat, ansonsten false
     */
    public boolean hinzufuegenVorne(Person p) {
        // Hier wird geprüft, ob kein null-Wert via Parameter übergeben wurde
        if(p!=null) {
            // Beschaffen der aktuellen Anzahl Referenzen in Sammlung
            int aktAnzahl = personen.size();
            personen.add(0,p);
            // Prüfung, ob die Grösse der Sammlung vergrössert wurde. Wenn ja,
            // ist dies ein Indiz, dass das Hinzufügen geklappt hat
            if(personen.size()>aktAnzahl) {
                return true;
            }
        }
        return false;
    }

    /**
     * Fügt eine Objektreferenz des Typs Person am Ende der Sammlung hinzu
     * Dies ist das Standardverhalten einer ArrayList. Neue Elemente werden
     * immer am Ende der Liste hinzugefügt. Daher sind keine speziellen
     * Massnahmen zu treffen, um eine Referenz am Ende zu speichern
     * @param p Erwartet Objektreferenz des Typs Person
     * @return Liefert true, wenn das Hinzufügen geklappt hat, ansonsten false
     */
    public boolean hinzufuegenHinten(Person p) {
        // Hier wird geprüft, ob kein null-Wert via Parameter übergeben wurde
        if(p!=null) {
            return personen.add(p);
        }
        return false;
    }

    /** 
     * Fügt eine Objektreferenz des Typs Person an einer gewünschten Position
     * innerhalb der Sammlung hinzu. Die Position, welche per Parameter übergeben
     * wird, muss natürlich einem gültigen Index der Sammlung entsprechen
     * @param p Erwartet Objektreferenz des Typs Person
     * @param position Gültige Position innerhalb der Sammlung
     * @return Liefert true, wenn das Hinzufügen geklappt hat, ansonsten false
     */
    public boolean hinzufuegen(Person p, int position) {
        // Hier wird geprüft, ob kein null-Wert via Parameter übergeben wurde
        // Zusätzlich wird gepfrüft, ob der Wert in position gültig ist
        if(p!=null && (position >= 0 && position < personen.size())) {
            int aktAnzahl = personen.size();
            personen.add(position, p);
            if(personen.size() > aktAnzahl) {
                return true;
            }
        }
        return false;
    }

    /**
     * Entfernt eine Objektreferenz an einer bestimmten Position 
     * aus der Sammlung, sofern der übergebene Index gültig ist
     * @param position Erwartet einen gültigen Index innerhalb der Sammlung
     * @return Liefert true, wenn das Hinzufügen geklappt hat, ansonsten false
     */
    public boolean entferne(int position) {
        // Prüfung, ob der Wert in position gültig ist
        if(position >=0 && position < personen.size()) {
            // Wenn die Methode .remove benutzt wird (siehe API), liefert
            // die Methode die Referenz des gelöschten Objekts zurück.
            // Klappt das Löschen nicht, liefert die Methode .remove den 
            // Wert null. Somit kann also geprüft werden, ob das Löschen
            // funktioniert hat. Liefert die Methode also kein null, wurde
            // tatsächlich eine Objektreferenz entfernt.
            if(personen.remove(position)!=null) {
                return true;
            }
        }
        return false;
    }

    /** 
     * Liefert die Anzahl gespeicherten Objektreferenzen der Sammlung
     * Die Zählung beginnt bei 1
     * @return Anzahl gespeicherter Referenzen der Sammlung
     */
    public int gibAnzahl() {
        return personen.size();
    }

    /** 
     * Generiert in der Konsole eine Liste mit allen Attributen der
     * gespeicherten Objekte
     */
    public void zeigeDaten() {
        // Prüfung, ob sich überhaupt Objektreferenzen in der Sammlung befinden
        if(personen.size()>0) {
            for(Person p : personen) {
                // Beschaffen der Attributwerte einer Person durch den externen
                // Methodenaufruf .gibPersonAlsString(), welcher in der Klasse
                // Person implementiert wurde.
                String datenEinerPerson = p.gibPersonAlsString();
                System.out.println(datenEinerPerson);
            }   
        }
        else {
            System.out.println("Keine Daten in der Sammlung vorhanden!");
        }
    }

    /**
     * Sucht einen bestimmten Nachnamen in der Sammlung und liefert
     * die Referenz des ersten Objekts zurück, welchem dem Nachnamen
     * entspricht.
     * @param nachname Der gesuchte Nachname 
     * @return Referenz des gefundenen Objekts, ansonsten null
     */
    public Person suchePersonNachNachname(String nachname) {
        for(Person p : personen) {
            // Strings sollten niemals mit == verglichen werden. Dies
            // gilt im Übrigen für alle Objektreferenzen. Dafür bieten
            // Objekte jeweils die Methode equals() an. Das == zwischen
            // zweier Objektreferenzen prüft nur, ob diese auf dasselbe
            // Objekt zeigen, nicht aber, ob sie inhaltich identisch sind
            // Die Theorie dazu wird im Unterricht noch eingehend behandelt
            if(p.gibNachname().equals(nachname)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Durchsucht die Sammlung nach einem gewünschten Nachnamen und liefert
     * die Anzahl der Objekte zurück, welche diesen Nachnamen als Wert tragen
     * @param nachname Der gesuchte Nachname
     * @return Anzahl der gefundenen Objekte, welche dem Nachnamen entsprechen
     */
    public int suchePersonenMitBestimmtenNachnamen(String nachname) {
        // Zählervariable, wird bei jeder Übereinstimmung (siehe Schleife)
        // um eins nach oben gezählt
        int counter = 0;
        for(Person p : personen) {
            // Strings sollten niemals mit == verglichen werden. Dies
            // gilt im Übrigen für alle Objektreferenzen. Dafür bieten
            // Objekte jeweils die Methode equals() an. Das == zwischen
            // zweier Objektreferenzen prüft nur, ob diese auf dasselbe
            // Objekt zeigen, nicht aber, ob sie inhaltich identisch sind
            // Die Theorie dazu wird im Unterricht noch eingehend behandelt
            if(p.gibNachname().equals(nachname)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Durchsucht die Sammlung nach einem Objekt, welches dem per
     * Parameter übergebenen Objekts inhaltlich entspricht, also dieselben
     * Werte in den Attributen trägt.
     * @param p Objektreferenz des Vergleichobjekts 
     * @return Liefert die Objektreferenz der gefundenen Person 
     */
    public Person suchePerson(Person p) {
        // Die Methode .indexOf beschafft sich die Position einer Objektreferenz
        // innerhalb der Sammlung. Wird kein Objekt gefunden, liefert die Methode
        // den Wert -1
        int position = personen.indexOf(p);
        if(position != -1) {
            return personen.get(position);
        }
        return null;
    }

    /**
     * Entfernt die Objektreferenzen aus der Sammlung, welche inhaltlich
     * dem Parameter p entspricht. Wenn alle Werte des Objekts p sowie
     * einem Objekt der Sammlung identisch sind, werden die Refernzen
     * aus der Sammlung gelöscht.
     * @param p Objektreferenz des Vergleichobjekts 
     * @return Anzahl gelöschter Objektreferenzen
     */
    public int entferne(Person p) {
        int wievielePersonenGeloescht = 0;
        // Lokale Hilfs-ArrayList, welche die zu Löschenden Objektreferenzen
        // während der Methodenausführung zwischenspeichert (siehe Erklärung
        // unten)
        ArrayList<Person> zuLoeschendePersonen = new ArrayList<Person>();
        for(Person ps : personen) {
            if( ps.gibVorname().equals(p.gibVorname()) &&
            ps.gibNachname().equals(p.gibNachname()) &&
            ps.gibAlter()==p.gibAlter() &&
            ps.gibTelefonnummer().equals(p.gibTelefonnummer()) &&
            ps.gibMobiltelefonnummer().equals(p.gibMobiltelefonnummer()) ) {
                // Das direkte Löschen innerhalb der Schleife funktioniert nicht, da
                // die Sammlung sich ja aufgrund eines .remove reorganisiert und
                // die for-each Schleife daher nicht mehr weiss, welches Objekt nun
                // an der Reihe ist. Daher kann das Löschen nicht direkt aus einer
                // Schleife ausgelöst werden.
                // personen.remove(ps); wäre also nicht möglich
                wievielePersonenGeloescht++;
                
                // Die zu löschenden Referenzen werden in der HilfsarrayList gespeichert
                zuLoeschendePersonen.add(ps);
            }
        }
        // Dank der Methode removeAll können nun alle Referenzen der Sammlung personen
        // auf einen Schlag entfernt werden. Dabei erwartet removeAll eine Liste mit 
        // jenen Referenzen, welche gelöscht werden sollen. Wie zu erkennen ist, wird
        // die Methode .removeAll nach der Ausführung der Schleife ausgeführt.
        personen.removeAll(zuLoeschendePersonen);
        return wievielePersonenGeloescht;
    }

    /**
     * Liefert eine ArrayList mit allen Referenzen, welche inhaltlich dem
     * Objekt p entsprechen. 
     * @param Objektreferenz des Vergleichobjekts 
     * @return Liste mit allen Referenzen, welche inhaltlich gleich sind wie Vergleichsobjekt
     */
    public ArrayList<Person> suchePersonen(Person p) {
        ArrayList<Person> gefundenePersonen = new ArrayList<Person>();

        for(Person ps : personen) {
            if( ps.gibVorname().equals(p.gibVorname()) &&
            ps.gibNachname().equals(p.gibNachname()) &&
            ps.gibAlter()==p.gibAlter() &&
            ps.gibTelefonnummer().equals(p.gibTelefonnummer()) &&
            ps.gibMobiltelefonnummer().equals(p.gibMobiltelefonnummer()) ) {

                gefundenePersonen.add(ps);
            }
        }
        return gefundenePersonen;
    }
    
    /**
     * Generiert einige Objekte des Typs Person, um die Sammlung zu testen.
     * @return Anzahl der in der Sammlung befindlichen Objektreferenzen
     */
    public int generiereTestDaten() {
        personen.add(new Person("Max", "Muster", 23, "071-123 45 67", "079-987 65 43"));
        personen.add(new Person("Anna", "Bolika", 99, "071-999 88 77", "079-666 55 44"));
        personen.add(new Person("Anna", "Bolika", 99, "071-999 88 77", "079-666 55 44"));
        personen.add(new Person("Bernhard", "Junker", 42, "071-111 22 33", "079-111 22 33"));
        
        return personen.size();
    }
}