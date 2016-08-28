
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
}
