
/**
 * Beschreiben Sie hier die Klasse Personenverwaltung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.*;

public class Personenverwaltung
{
    private ArrayList<Person> personen;
    
    public Personenverwaltung(){
        personen = new ArrayList<Person>();
    }
    
    public boolean hinzufuegen(Person p){
        if(personen.add(p)) return true;
        else return false;
    }
    
    public void hinzufuegenVorne(Person p){
        personen.add(0,p);
    }
    
    public boolean hinzufuegenHinten(Person p){
        if(personen.add(p)) return true;
        else return false;
    }
    
    public void hinzufuegen(Person p, int position){
        personen.add(position, p);
    }
    
    public boolean entferne(int position){
        if (position<personen.size() && position>=0){
            personen.remove(position);
            return true;
        }
        else return false;
    }
    
    public int gibAnzahl(){
        return personen.size();
    }
    
    public void zeigeDaten(){
        for(Person p:personen){
            p.gibPersonAlsString();
        }
    }
    
    public Person suchePersonNachNachname(String nachname){
        for(Person p:personen){
            if (p.getNachname()==nachname) return p;
        } 
        return null;
    }
    
    public int suchePersonenMitBestimmtenNachname(String nachname){
        int counter = 0;
        for(Person p:personen){
            if(p.getNachname()==nachname) counter++;
        }
        return counter;
    }
    
    public Person suchePerson(Person p){
        for(Person pers:personen){
            if(pers == p) return pers;
        }
        return null;
    }
    
    public int entferne(Person p){
        int counter = 0;
        for(Person pers:personen){
            if(pers==p){
                personen.remove(counter);
                counter++;
            }
        }
        return counter;
    }
    
    public ArrayList<Person> suchePersonen(Person p){
        ArrayList<Person> persTemp = new ArrayList<Person>();
        Iterator<Person> it = personen.iterator();
        
        while(it.hasNext()){
            Person ps = it.next();
            if(ps.equals(p)){
                persTemp.add(ps);
            }
        }
        return persTemp;
    }
    
    public void personenErstellen(){
        personen.add(new Person("Kurt", "Müller", 22, "1234", "3456"));
        personen.add(new Person("Phillip", "Meier", 22, "1234", "3456"));
        personen.add(new Person("Max", "Müller", 22, "1234", "3456"));
        personen.add(new Person("Jan", "Müller", 22, "1234", "3456"));
        personen.add(new Person("Kurt", "Hugentoble", 22, "1234", "3456"));
        personen.add(new Person("Kurt", "Huber", 22, "1234", "3456"));
        personen.add(new Person("Kurt", "Lulu", 22, "1234", "3456"));
        personen.add(personen.get(0));
    }
}
