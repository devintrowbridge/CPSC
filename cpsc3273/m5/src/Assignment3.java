import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment3 {
   public static void main (String[] args) throws IOException {
      collectData();
   }

   public static void collectData() throws IOException {
      FileWriter out = new FileWriter ("output.txt");
      out.write(",Insertion Sort,,Quick Sort,,Merge Sort\n");
      out.write("n,T(n),T(n)/n^2,T(n),T(n)/nlogn,T(n),T(n)/nlogn\n");

      int arrsize = 10000000;
      long startTime;

      List<Integer> G = new ArrayList<Integer>(arrsize);
      fillArray(G, arrsize);

      List<Integer> A = new ArrayList<Integer>();
      for (int n = 4000; n < arrsize; n += 1000) {
         double[] dT = new double[3];
         double[] timeComplexity = new double[3];

         // InsertSort
         A = new ArrayList<>(G.subList(0, n));
         startTime = System.nanoTime();
         InsertSort(A);
         dT[0] = (double) System.nanoTime() - startTime;
         timeComplexity[0] = dT[0] / (n*n);

         // QuickSort
         A = new ArrayList<>(G.subList(0, n));
         startTime = System.nanoTime();
         QuickSort(A,0,n-1);
         dT[1] = (double) System.nanoTime() - startTime;
         timeComplexity[1] = dT[1] / (n*Math.log(n));

         // Merge Sort
         A = new ArrayList<>(G.subList(0, n));
         startTime = System.nanoTime();
         MergeSort(A,0,n-1);
         dT[2] = (double) System.nanoTime() - startTime;
         timeComplexity[2] = dT[2] / (n*Math.log(n));

         String outString = n + ","
                 + dT[0] + "," + timeComplexity[0] + ","
                 + dT[1] + "," + timeComplexity[1] + ","
                 + dT[2]+  "," + timeComplexity[2] + "\n";

         out.write(outString);

         if (n % 10000 == 0)
         {
            System.out.println("n = " + n);
            out.flush();
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

   public static void InsertSort(List<Integer> A) {
      for (int i = 0; i < A.size(); i++) {
         for (int j = i; j > 0; j--) {
            if (A.get(j) < A.get(j - 1)) {
               swap(A, j, j - 1);
            } else {
               break;
            }
         }
      }
   }

   public static void QuickSort(List<Integer> A, int lo, int hi) {
      if (hi <= lo) {
         return;
      }
      //int j = partition(a, lo, hi);
      int j = Partition(A, lo, hi);
      QuickSort(A, lo, j - 1);
      QuickSort(A, j + 1, hi);
   }

   private static int Partition(List<Integer> A, int left, int right) {
      Integer pivot = A.get(right);
      int i = left - 1; // i will become the final index of pivot
      for (int j = left; j < right; j++) {
         if (A.get(j) < pivot) {
            i++;
            swap(A, i, j);
         }
      }
      swap(A, i+1, right); // move pivot to its correct location
      return i+1;
   }

   public static void MergeSort(List<Integer> A, int p, int r) {
      if (p < r) {
         int q = (p + r) / 2;
         MergeSort(A, p, q);
         MergeSort(A, q + 1, r);
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

   /** Swaps the values in a[i] and a[j]. */
   private static void swap(List<Integer> a, int i, int j) {
      Integer temp = a.get(i);
      a.set(i, a.get(j));
      a.set(j, temp);
   }

}
