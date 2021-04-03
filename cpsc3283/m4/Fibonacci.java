import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {

public static void main(String[] args) throws IOException  {
collectData();
}

public static void collectData() throws IOException {
    System.out.println("Running...");
    FileWriter out = new FileWriter("output.txt");
    
    out.write(",Recursive,,Dynamic,,Iterative\n");
    //out.write("");
    long startTime = 0;
    long endTime = 0;
    String outString = "";

for (int i = 0; i <= 55; i++)    {
    double[] dT = new double[3];
    //--------------timing recursive----------------//
    startTime = System.nanoTime();
    recursiveFibonacci(i);
    endTime = System.nanoTime();
    dT[0] = (double) endTime - startTime;

    //--------------timing dynamic----------------//
    startTime = System.nanoTime();
    dpFibonacci(i);
    endTime = System.nanoTime();
    dT[1] = (double) endTime - startTime;

    //--------------timing iterative----------------//
    startTime = System.nanoTime();
    iterativeFibonacci(i);
    endTime = System.nanoTime();
    dT[2] = (double) endTime - startTime;

    //---------------writing string to output-------------//
    outString = i + "," + dT[0] + "," + dT[1] + "," + dT[2] + "\n";
    out.write(outString);
    
}   

out.close();
System.out.println("Done...");
}



public static int recursiveFibonacci(int n) {
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }
    return (recursiveFibonacci(n-1) + recursiveFibonacci(n-2));
}


public static int dpFibonacci(int n)    {
    int[] table = new int[100];

    for (int i = 0; i <table.length; i++)   {
    table[i] = -1;
        }

    if (n <= 2) {
        return 1;
    }

    if (table[n] != -1)  {
        return table[n];
    }
    
    for (int i = 2; i <= n; i++)    {
        table[i] = table[i-1] + table[i-2];
    }
    return table[n];

    //int f = dpFibonacci(n-1) + dpFibonacci(n-2);
    //table[n] = f;
   // return f;     
    }

    public static int iterativeFibonacci(int n) {
        //if (n <=2)  {
        //    return 1;
       // }
       // int[] array = new int[n];
       // array[0] = 1;
       // array[1] = 1;
       // for (int i = 2; i < array.length; i++)  {
      //      array[i] = array[i-2] + array[i-1];
       // }
       // return array[n-1];

        int fib = 0;
        int x = 1;
        for (int i = 0; i < n; i++) {
            fib = fib + x;
            x = fib;
        }
        return fib;
    }
}