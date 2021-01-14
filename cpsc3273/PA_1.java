import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class PA_1
{
    //================================================
    public static void main(String[] args) throws IOException {
        boolean[][] matrixG = new boolean[10000][10000];
        Generate_Matrix(matrixG);

        FileWriter  out = new FileWriter ("C:\\Users\\Tower\\Desktop\\output.txt");

        for (int n = 100; n < matrixG.length; n += 100) {
            boolean[][] matrixA = new boolean[n][n];
            Copy_Matrix(matrixA, matrixG, n);

            // Start time
            long startTime = System.nanoTime();
            for (int i = 0; i < n-2; ++i) {
                for (int j = i + 1; j < n-1; ++j) {
                // swap A[i] and A[j]
                boolean buffer = matrixA[i][j];
                matrixA[i][j] = matrixA[j][i];
                matrixA[j][i] = buffer;
                }
            }
            // End time
            long endTime = System.nanoTime();
            double[] dT = new double[4];
            dT[0] = (endTime - startTime);
            dT[1] = (double) dT[0] / (double) n;
            dT[2] = (double) dT[1] / (double) n;
            dT[3] = (double) dT[2] / (double) n;
            
            String outString = n + "," 
                                 + dT[0] + "," 
                                 + dT[1]+ "," 
                                 + dT[2]+ "," 
                                 + dT[3] + "\n";

            out.write(outString);
        }

        out.close();
    }

    //================================================
    private static void Generate_Matrix(boolean[][] matrix){
        Random generator = new Random();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = generator.nextBoolean();
            }
        }
    }

    //================================================
    private static void Copy_Matrix(boolean[][] matrixA, 
                                    boolean[][] matrixG,
                                    int n){
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrixA[i][j] = matrixG[i][j];
            }
        }
    }
}