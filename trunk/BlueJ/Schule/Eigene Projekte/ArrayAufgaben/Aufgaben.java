import java.io.*;
import java.util.*;

public class Aufgaben
{
    
    public void aufgabe1(){
        int[] data = new int[20];
        
        for(int i=0; i<data.length; i++){
            data[i] = 1;
        }
        
        System.out.println(data[0]);
        System.out.println(data[9]);
        System.out.println(data[19]);
        System.out.println(data[25]); //Index out of bounds
    }
    
    public void aufgabe2(){
        int[] data = new int[100];
        
        for(int i = 0; i<data.length; i++){
            data[i] = i+1;
        }
        
        for(int j=0; j<data.length; j++){
            System.out.print(data[j] + " ");
        }
    }
    
    public void aufgabe3(int anzahl){
        int[] data = new int[anzahl];
        
        for(int i = 0; i<data.length; i++){
            data[i] = i;
        }
        
        int[] data_copy = new int[data.length];
        int counter = 0;
        for(int j=data_copy.length-1; j>=0; j--){
            data_copy[counter] = data[j];
            System.out.println("data: " + counter + " data_copy: " + j);
            counter++;
        }
    }
    
    public void aufgabe4(){
        int[] data = new int[20];
        
        Random r;
        int zufallszahl;
        int nullOffset = 1;
        int obergrenze = 1000;
        r = new Random();
        
        for(int i=0; i<data.length; i++){
            data[i] = zufallszahl = r.nextInt(obergrenze) + nullOffset;
        }
        
        int min = 1000;
        int max = 0;
        int schnitt = 0;
        
        for(int j=0; j<data.length; j++){
            if(data[j]>max) max = data[j];
            if(data[j]<min) min = data[j];
            schnitt+= data[j];
        }
        
        System.out.println("Minimaler Wert: " + min);
        System.out.println("Maximaler Wert: " + max);
        System.out.println("Druchschnitt: " + (schnitt/data.length));
    }
    
    public void aufgabe5(){
        char[] data = new char[10];
        
        Random r;
        int zufallszahl;
        int nullOffset = 65;
        int obergrenze = 26;
        r = new Random();
        int counter = 0;
        for(int i=0; i<data.length; i++){
            zufallszahl = r.nextInt(obergrenze) + nullOffset;
            data[i] = (char)zufallszahl;
        }
        
        for(int k=65; k<=90; k++){
            char b = (char)k;
            for(int j=0; j<data.length; j++){
                if(data[j]==k) counter++;
            }
            System.out.println("Buchstabe " + b + ": " + counter);
            counter = 0;
        }
    }
    
    public void aufgabe6(int anzahl, int grenze){
        int[] data = new int[10];
        
        Random r;
        int zufallszahl;
        int nullOffset = 1;
        int obergrenze = 0;;
        if(grenze>1) obergrenze = grenze;
        r = new Random();
        int counter = 0;
        
        for(int i=0; i<data.length; i++){
            zufallszahl = r.nextInt(obergrenze) + nullOffset;
            data[i] = zufallszahl;
            counter+= data[i];
        }
        
        System.out.println("Anzahl Zahlen: " + data.length);
        System.out.println("Obergrenze: " + obergrenze);
        System.out.println("Summe: " + counter);
       
        for(int j=0; j<data.length; j++){
            double schnitt = (double)(data[j]/(double)(counter/100));
            System.out.println("Zahl " + data[j] + ": " +schnitt+ "%");
        }
    }
    
    public void aufgabe7(){
        int[] data = new int[19];
        
        Random r;
        int zufallszahl;
        int nullOffset = 1;
        int obergrenze = 20;
        r = new Random();
        int counter = 0;
        
        for(int i=0; i<data.length; i++){
            zufallszahl = r.nextInt(obergrenze) + nullOffset;
            data[i] = zufallszahl;
        }
        
        int temp=0;
        for(int j=0; j<data.length; j++){
           for(int k=0; k<data.length-1; k++){
               if(data[j]>data[j+1]){
                   temp=data[j];
                   data[j]=data[j+1];
                   data[j+1] = temp;
               }
           } //Ausgabe fehlt
        }
    }
}
