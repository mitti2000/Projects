public class Datentypen
{
    private int a;
    private int b;
    private double c;
    private char d;

    public Datentypen()
    {
        a = 1;
        b = 3;
        c = 2.4679;
        d = 'E';
    }

    public void division1()
    {
        System.out.println(a / b);
        System.out.println(a /(double) b);
        System.out.println((double) a / b);
        System.out.println((double)(a / b));
    }

    public void division2()
    {
        int res1;
        res1 = a / b;
        System.out.println(res1);

        double res2;
        res2 = a / b;
        System.out.println(res2);

        double res3;
        res3 = a / c;
        System.out.println(res3);
    }

    public void doubleToInt()
    {
        System.out.println((int) c);
    }

    public void intToChar()
    {
        int f = 65;
        System.out.println((char) f);
        System.out.println((int) d);
    }
    
    public void intStringOperation()
    {
        String num1="12";
        String num2="24";
        
        System.out.println(num1+num2);
        
        int num1Int;
        int num2Int;
        num1Int=Integer.parseInt(num1);
        num2Int=Integer.parseInt(num2);
        
         System.out.println(num1Int+num2Int);
    }
}