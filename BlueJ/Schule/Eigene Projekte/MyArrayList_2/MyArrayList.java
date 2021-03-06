import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse MyArrayList.
 * 
 * @author Thomas Mittermair 
 * @version August 2016
 */
public class MyArrayList
{
    private Person[] personen;

    /**
     * Erstellt eine neue MyArrayList mit 2 leeren Elementen
     */
    public MyArrayList(){
        personen = new Person[2];
    }

    /**
     * Private Methode. Erhöht die Grösse des Arrays um die Hälfte der belegenten Elemente(abgerundet)
     */
    private void resize(){
        int anzahlFreiePlaetze = 0;
        int anzahlBelegtePlaetze = 0;
        Person[] tempPersonen;

        for(int i=personen.length-1; i>-1; i--){
            if(personen[i]==null) anzahlFreiePlaetze++;
        }

        anzahlBelegtePlaetze = personen.length-anzahlFreiePlaetze;

        if(anzahlFreiePlaetze<=1){
            if(anzahlBelegtePlaetze>1)tempPersonen = new Person[personen.length + (anzahlBelegtePlaetze/2)];
            else if(anzahlBelegtePlaetze==1) tempPersonen = new Person[personen.length + 1];
            else tempPersonen = new Person[2];

            for(int j=0; j<personen.length; j++){
                tempPersonen[j] = personen[j];
            }

            personen = new Person[tempPersonen.length];

            for (int k=0; k<tempPersonen.length; k++){
                personen[k] = tempPersonen[k];
            }
        }

    }

    /**
     * Private Methode. Räumt das Array auf so dass keine leeren Speicherplätze mehr vorhanden sind ausser am Ende des Arrays
     */
    private void cleanup(){
        boolean isClean = false; 
        Person tempPerson; 
        int belegtePositionen = 0; 

        for(int j=0; j<personen.length; j++){
            if(personen[j] != null) belegtePositionen++; //Schleife läuft bis Wert 2 und nicht 1!
        }

        while(!isClean && belegtePositionen>0){
            isClean = true; 

            for(int i=0; i<(personen.length-1);i++){
                if(personen[i]==null && personen[i+1]!=null){
                    tempPerson=personen[i];
                    personen[i]=personen[i+1];
                    personen[i+1]=tempPerson; 
                    isClean=false; 
                }
            }
        }
    }

    /**
     * Fügt eine Personen Objekt dem Array hinzu
     * @param p Personen Objekt das hinzugefügt werden soll
     * @return true wenn die Person hinzugefügt wurde
     */
    public boolean add(Person p){ 
        boolean found = false;
        int position = -1;
        cleanup();

        for(int i=personen.length-2;i>-1;i--){
            if(!found && personen[i]!=null && personen[i+1]==null) { //erste Position wo ein Element drin ist von hinten angefangen
                found=true;
                position = i+1;
                found = true;
            }
        }

        if(!found && position == -1){
            position = 0;
        }

        if (position>-1 && p!=null) {
            personen[position]=p;
            resize();
            return true;
        }

        else return false;        
    }

    /**
     * Fügt eine Personen Objekt dem Array an einer bestimmten Position hinzu
     * @param index Index an welchem das Objekt hinzugefügt werden soll
     * @param p Personen Objekt das hinzugefügt werden soll
     * @return true wenn die Person hinzugefügt wurde
     */
    public boolean add(int index, Person p){

        if(personen[index]==null && index<personen.length && index>-1 && p!=null){
            personen[index]=p;
            cleanup();
            resize();
            return true;
        }

        else if(personen[index]!=null && index<personen.length && index>-1  && p!=null){
            for(int i=personen.length-2;i>=index; i--){
                personen[i+1] = personen[i];
                personen[i] = null;
            }

            personen[index]=p;
            cleanup();
            resize();
            return true;
        }

        else return false;
    }

    /**
     * Löscht eine Elemtent an einer bestimmten Stelle
     * @param index Index welcher gelöscht werden soll
     * @return Person Element das gelöscht wurde
     */
    public Person remove(int index){
        if(index<personen.length){
            if(personen[index]!=null){
                Person tempPerson;
                tempPerson = personen[index];
                personen[index]=null;
                cleanup();
                return tempPerson;
            }
            else return null;
        }
        else return null;
    }

    /**
     * Löscht das erste Elemtent im Array, dass der übergebenen Person entspricht
     * @param p Person die gelöscht werden soll
     * @return true wenn die Person gelöscht wurde
     */
    public boolean remove(Person p){
        Person tempPerson=null;
        boolean personGefunden = false;
        int index = 0;
        if(p!=null){
            while(!personGefunden && index<personen.length  && personen[index]!=null){
                if(personen[index].equals(p) && !personGefunden){
                    personen[index] = null;
                    personGefunden=true;
                }
                index++;
            }
        }
        cleanup();
        return personGefunden;
    }

    /**
     * Löscht alle Elemente aus der Sammlung. Das Array hat danach wieder 2 leere Elemente
     */
    public void clear(){
        for(int i =0; i<personen.length; i++){
            personen[i] = null;
            trimToSize();
        }
    }

    /**
     * Liefert eine Person an einem bestimmten Index zurück
     * @param index Index der gewünschten Person
     * @return Person Person an gewünschten Index
     */
    public Person get(int index){
        if(index>-1 && index<personen.length){
            return personen[index];
        }
        else return null;
    }

    /**
     * Liefert die Grösse des Arrays zurück
     * @return int Grösse des Arrays
     */
    public int size(){
        return personen.length;
    }

    /**
     * Ersetzt ein Objekt an einer bestimmten Stelle mit dem gewüschten Objekt
     * @param index Gewünschter Index der ersetzt werden soll
     * @param p Objekt das an der gewüschten Stelle gespeichert werden soll
     * @retun Person Person die vorher an der gewüschten Stelle war
     */
    public Person set(int index, Person p){
        Person tempPerson=null;
        if(index>-1 && index<personen.length && p!=null){
            tempPerson = personen[index];
            personen[index] = p;
        }

        return tempPerson;
    }

    /**
     * Gibt die ArrayList als Array ohne leere Elemente zurück
     * @return Person[] Die ArrayList als Array ohne leere Elemente
     */
    public Person[] toArray(){ 
        Person[] tempPersonen;
        int counter = 0;

        for(int i=0; i<personen.length; i++){
            if(personen[i]!=null){
                counter++;
            }
        }

        if(counter>0){
            tempPersonen = new Person[counter];
            for(int i=0; i<counter;i++){
                tempPersonen[i] = personen[i];
            }
        }
        else tempPersonen = new Person[0];

        return tempPersonen;
    }

    /**
     * Schneidet das Array auf alle belegten und 2 leere Elemente zu
     */
    public void trimToSize(){
        Person[] tempPersonen;

        int counter = 0;

        for(int i=0; i<personen.length; i++){
            if(personen[i]!=null){
                counter++;
            }
        }

        if(counter>0){
            tempPersonen = new Person[counter+2];
            for(int i=0; i<counter;i++){
                tempPersonen[i] = personen[i];
            }
        }
        else tempPersonen = new Person[2];

        personen = tempPersonen;
    }

    /* *********************************************************************
     * Neue Mathoden ab 13.9.16
     *********************************************************************** */
    /*
     * Entfernt alle mehrfach vokommenden Perosnen und behält ein Exemplar der Sammlung
     * @return boolean True wenn alles suaber gelöscht wurde
     */
    public boolean removeDuplicates(){
        for(int i=0;i<personen.length-1;i++){
            if(personen[i]!=null){
                for(int j=i+1; j<personen.length;j++){
                    if(personen[j] != null){
                        if(personen[j].equals(personen[i])) personen[j] = null;
                    }
                }
            }
        }
        cleanup();
        return true;
    }

    /*
     * Gibt eine nach dem Vornamen sortierte Liste zurück, ohne die interne Sammlung der Klasse zu beinflussen.
     * Wenn der Parameter true ist, wird absteigend, ansonsten aufsteigend sortiert.
     * @return Person[] Nach Vornamen sortierte Liste
     * @param direction true = absteigen, false = aufsteigend
     */
    public Person[] sortByFirstname(boolean direction){
        Person[] personenTemp = personen;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i=0; i<personenTemp.length-1;i++){
                if(personenTemp[i]!=null && personenTemp[i+1] != null){
                    if(direction && personenTemp[i].getVorname().compareToIgnoreCase(personenTemp[i+1].getVorname())<0){
                        Person temp = personenTemp[i];
                        personenTemp[i] = personenTemp[i+1];
                        personenTemp[i+1] = temp;
                        isSorted = false;
                    }

                    else if(!direction && personenTemp[i].getVorname().compareToIgnoreCase(personenTemp[i+1].getVorname())>0){
                        Person temp = personenTemp[i];
                        personenTemp[i] = personenTemp[i+1];
                        personenTemp[i+1] = temp;
                        isSorted = false;
                    }
                }
            }
        }
        return personenTemp;
    }

    /*
     * Verschiebt ein Element der Sammlung an eine neue Stelle, Liefert rue bei Erfolg, ansosnten false
     * @return true bei Erfolg, sonst false
     * @param p zu verschiebende Person
     * @param position Position wo die Person hinsoll als int
     */
    public boolean move(Person p, int position){
        boolean isFound =false;
        int zaehler = -1;
        Person tempPerson;
        if(p != null){
            while(!isFound && zaehler<personen.length-1){
                zaehler++;
                if(personen[zaehler].equals(p)) isFound = true;
            }
            tempPerson = personen[zaehler];
            personen[zaehler]=null;
            cleanup();
            return add(position, tempPerson);
        }
        return false;
    }

    /*
     * Liefert eine invertierte Version der Sammlung in Form einer ArrayList zurück ohne die interne Sammlung der Klasse zu beeinflussen
     * @return ArrayList<Person> Invertierte Liste als ArrayList
     */
    public ArrayList<Person> invert(){
        ArrayList<Person> personenArray = new ArrayList<Person>();
        for(int i=personen.length-1; i>=0; i--){
            if(personen[i] != null) personenArray.add(personen[i]);
        }
        return personenArray;
    }

    /*
     * Liefert einen Abschnitt der Sammlung von Position from bis und mit Position to. Wenn remove true ist, wird die Sammlung um diesen Bereich gekürzt,
     * bei false wird nur der Ausschnitt zurückgegeben ohne dass die interne Sammlung der Klasse beeinflusst wird
     * @return Person[] Gewünschter Ausschnitt als Array
     * @from Startposition
     * @to Endposition
     * @remove Soll der Abschnitt aus dem Array entfernt werden?
     */
    public Person[] cutOut(int from, int to, boolean remove){
        int anzahl;
        int start = 0;
        int stop = 0;
        //Überprüfung, ob from und to im gültigen Bereich
        if(from>to) {
            anzahl = (from - to)+1;
            start = to;
            stop = from;
        }
        else if (to>from) {
            anzahl = (to-from)+1;
            start = from;
            stop = to;
        }
        else anzahl = 0;
        Person[] personenTemp = new Person[anzahl];
        int zaehler=0;
        if(anzahl>0){
            for(int i=start; i<=stop; i++){
                personenTemp[zaehler] = personen[i];
                if(remove) personen[i]=null;
                zaehler++;
            }
        }
        if (remove && anzahl>0) cleanup();    
        return personenTemp;
    }

    /*
     * Fügt eine Sammlung in der bestehende Sammlung der Klasse ein. Liefert tur bei Erfolg, oder false bei Misserfolg
     * @return true bei Erfolf, false bei Misserfolg
     * @param p Einzufügende Liste als Array
     * @param position Einzufügende Position als int
     */
    public boolean insert(Person[] p, int position){
        int zaehler = 0;
        boolean allesGut = false;
        for(int i = 0; i<p.length; i++){
            if(p[i] != null){
                allesGut = add(position+zaehler, p[i]);
                zaehler++;
            }
        }

        return allesGut;
    }

    /*
     * Fügt eine Sammlung in der bestehende Sammlung der Klasse ein. Liefert tur bei Erfolg, oder false bei Misserfolg
     * @return true bei Erfolf, false bei Misserfolg
     * @param p Einzufügende Liste als ArrayList
     * @param position Einzufügende Position als int
     */
    public boolean insert(ArrayList<Person> p, int position){
        Person[] personenTemp = new Person[p.size()];
        for(int i=0; i<personenTemp.length; i++){
            personenTemp[i] = p.get(i);
        }
        return insert(personenTemp, position);
    }

    //***************************************
    //Testmethoden
    //**************************************
    public void create10Diff(){
        add(new Person("1","1",1));
        add(new Person("2","2",1));
        add(new Person("3","3",1));
        add(new Person("4","4",1));
        add(new Person("5","5",1));
        add(new Person("6","6",1));
        add(new Person("7","7",1));
        add(new Person("8","8",1));
        add(new Person("9","9",1));
        add(new Person("10","10",1));
    }

    public void create10Mix(){
        add(new Person("Hans","Muster",1)); //0
        add(new Person("Philip","Müller",1)); //1
        add(new Person("Karl","Heinzelreiter",1)); //2
        personen[3] = personen[0];//3
        add(new Person("Thomas","Mittermair",1)); //4
        personen[5] = personen[4]; //5
        add(new Person("Max","Zinzer",1)); //6
        add(new Person("Xavier","Xaversson",1)); //7
        add(new Person("Max","Zinzer",1)); //8
        personen[9] = personen[2]; //9
    }
    
    public void createPersonArrayInsert1(){
        Person p = new Person("Thomas","Mittermair2",1);
        Person[] personenTemp = {p,p,p};
        
        insert(personenTemp,2);
    }
    
    public void createPersonArrayListInsert1(){
        Person p = new Person("Thomas","Mittermair2",1);
        ArrayList<Person> personenTemp = new ArrayList<Person>();
        personenTemp.add(p);
        personenTemp.add(p);
        personenTemp.add(p);        
        insert(personenTemp,2);
    }
}
