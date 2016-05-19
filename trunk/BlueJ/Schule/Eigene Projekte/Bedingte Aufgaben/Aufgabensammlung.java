
/**
 * Beschreiben Sie hier die Klasse Aufgabensammlung.
 * 
 * @author Thomas Mittermair 
 * @version 19.5.16
 */
public class Aufgabensammlung
{
    public int aufgabe1(int a, int b){
        if (a>b) return a;
        else if (a<b) return b;
        else {
            System.out.println("Zahlen sind gleich gross");
        return 0;
    }
    }
    
    public int aufgabe2(int a, int b, int c){
        if(a>b && a>c) return a;
        else if (b>a && b>c) return b;
        else if (c>a && c>b) return c;
        System.out.println("Zwei Zahlen sind gleich gross");
        return 0;
    }
    
    public void aufgabe3(int a){
        if(a>0) System.out.println("Zahl ist positiv");
        else if (a<0) System.out.println("Zahl ist negativ");
        else if (a==0) System.out.println("Zahl ist 0");
        
        if (a%2==1) System.out.println(" und ungerade");
        else if (a%2==0) System.out.println(" und gerade");
    }
    
    public void aufgabe4(int a, int b){
        if(b==0) System.out.println("Divison durch 0!!!");
        else System.out.println("Resultat von "+a+"/"+b+"="+(a/b));
    }
    
    public void aufgabe5(double a, double b, char c){
        if(c=='+') System.out.println(a + "+" + b + " ist gleich " + (a+b));
        else if(c=='-') System.out.println(a + "-" + b + " ist gleich " + (a-b));
        else if (c=='*') System.out.println(a + "*" + b + " ist gleich " + (a*b));
        else if (c=='/') {
            if(b==0.0) System.out.println("Division durch 0!!!");
            else System.out.println(a + "/" + b + " ist gleich " + (a/b));
            }
    }
    
    public void aufgabe6(double a, double b, char c){
        switch(c){
            case '+':
                System.out.println(a + "+" + b + " ist gleich " + (a+b));
                break;
            case '-':
                System.out.println(a + "-" + b + " ist gleich " + (a-b));
                break;
            case '*':
                System.out.println(a + "*" + b + " ist gleich " + (a*b));
                break;
            case '/':
                if(b==0.0) System.out.println("Division durch 0!!!");
                else System.out.println(a + "/" + b + " ist gleich " + (a/b));
                break;
            }
        }
        
    
}
