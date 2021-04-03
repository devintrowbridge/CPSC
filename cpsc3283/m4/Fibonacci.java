import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
    //===================================================================
    public static void main(String[] args) throws IOException  {
        // Initialize memoization table 
        table = new int[100];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <table.length; i++) table[i] = -1;

        // Collect Data
        System.out.print("Running...");
        FileWriter out = new FileWriter("output.txt");
        
        out.write("i,Recursive,Dynamic,Iterative\n");
        for (int i = 0; i <= 43; i++) {
            double[] dT = new double[3];

            //--------------timing recursive----------------//
            long startTime = System.nanoTime();
            recursiveFibonacci(i);
            dT[0] = System.nanoTime() - startTime;

            //--------------timing dynamic----------------//
            startTime = System.nanoTime();
            dpFibonacci(i);
            dT[1] = System.nanoTime() - startTime;

            //--------------timing iterative----------------//
            startTime = System.nanoTime();
            iterativeFibonacci(i);
            dT[2] = System.nanoTime() - startTime;

            //---------------writing string to output-------------//
            out.write(i + "," + dT[0] + "," + dT[1] + "," + dT[2] + "\n");

            System.out.print(i + (i > 9 ? "\b\b" : "\b" )); // Output progress to command line
        }   

        out.close();
        System.out.println("\nDone.");
    }

    //===================================================================
    public static int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (recursiveFibonacci(n-1) + recursiveFibonacci(n-2));
    }

    //===================================================================
    private static int[] table;
    public static int dpFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        // If numbers are already in the table, use those instead of 
        // calculating again
        int n1 = (table[n-1] != -1) ? table[n-1] : dpFibonacci(n-1); 
        int n2 = (table[n-2] != -1) ? table[n-2] : dpFibonacci(n-2); 

        table[n] = n1 + n2;
        return table[n];     
    }

    //===================================================================
    public static int iterativeFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] numbers = {0,1,1};
        for (int i = 0; i < n-1; i++) {
            numbers[2] = numbers[0] + numbers[1]; // fibonacci calc
            
            // Store off numbers need for next iteration
            numbers[0] = numbers[1]; 
            numbers[1] = numbers[2];
        }
        
        return numbers[2];
    }
}