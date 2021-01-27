import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort {
   public static void main (String[] args) throws IOException {
      collectData();
   }

   public static void collectData() throws IOException {
      FileWriter out = new FileWriter ("output.txt");

      int arrsize = 10000;
      
      List<Integer> G = new ArrayList<Integer>(arrsize);
      fillArray(G, arrsize);

      List<Integer> A = new ArrayList<Integer>();
      for (int n = 1000; n < arrsize; n += 1000) {
         A = new ArrayList<>(G.subList(0, n));

         // Start time
         long startTime = System.nanoTime();

         Sort(A,0,n-1);

         // End time
         long endTime = System.nanoTime();
         long delta = endTime - startTime;
         double[] dT = new double[4];

         double logn = Math.log10(n) / Math.log10(2);

         dT[0] = delta;
         dT[1] = delta / logn;
         dT[2] = delta / (n * logn);
         dT[3] = (double) delta / n;

         String outString = n + ","
                 + dT[0] + ","
                 + dT[1]+ ","
                 + dT[2]+ ","
                 + dT[3]+ "\n";

         out.write(outString);

         if (n % 100000 == 0) {
            System.out.format("n = %d; T(n) = %.3fs%n", A.size(), delta / 1000000000.0);
         }
      }

      out.close();
   }

   public static void fillArray(List<Integer> G, int n) {
      Random generator = new Random();
      for (int i = 0; i < n; ++i) {
         G.add(generator.nextInt());
      }
   }

   public static void Sort(List<Integer> A, int p, int r) {
      if (p < r) {
         int q = (p + r) / 2;
         Sort(A, p, q);
         Sort(A, q + 1, r);
         Merge(A, p, q, r);
      }
   }

   public static void Merge(List<Integer> A, int p, int q, int r) {
      int n_1 = q-p+1;
      int n_2 = r-q;

      int[] L = new int[n_1 + 2];
      for (int i = 1; i <= n_1; ++i) {
         L[i] = A.get(p+i-1);
      }

      int[] R = new int[n_2 + 2];
      for (int j = 1; j <= n_2; ++j) {
         R[j] = A.get(q+j);
      }

      L[n_1+1] = Integer.MAX_VALUE;
      R[n_2+1] = Integer.MAX_VALUE;
      int i = 1;
      int j = 1;
      for (int k = p; k <= r; ++k) {
         if (L[i] <= R[j]) {
            A.set(k, L[i++]);
         }
         else {
            A.set(k, R[j++]);
         }
      }
   }
}
