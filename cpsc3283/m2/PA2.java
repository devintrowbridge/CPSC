import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PA2 {
    //===============================================
    public static void main(String[] args) throws IOException {
        FileWriter out = new FileWriter("output.txt");
        out.write("n, h, h/log(n), h/n\n");

        Random rng = new Random();
        // Generate tree with n nodes with random values
        for (int n = 500; n <= 20000; n += 500) {
            double sumHeight = 0;

            // Generate 10 trees
            for (int j = 1; j <= 10; j++)    {
                Node root = new Node(-1);

                // Fill up the tree
                for (int i = 1; i <= n; i++)    {
                    int p = rng.nextInt(n+1);
                    Node z = new Node(p);
                    treeInsert(root, z);
                }

                //measure the height
                int h = height(root);
                sumHeight += h;

                // Delete the tree
                root = null;
            }

            // Calculate things
            sumHeight /= 10.0;
            double hlogn = sumHeight / Math.log(n) / Math.log(2);
            double hn = sumHeight / n;

            // Write to log file
            String output = n + ", " + sumHeight + ", " + hlogn + ", " + hn;
            out.write(output + "\n");
        }

        out.close();
    }

    //===============================================
    public static void treeInsert(Node root, Node z) {
        Node y = null;
        Node x = root;

        while (x != null && x.element != -1)   {
            y = x;
            x = (z.element < x.element) ? x.left : x.right;
        }

        z.parent = y;
        if (y == null)                 root.copy(z);
        else if(z.element < y.element) y.left = z;
        else                           y.right = z;
    }

    //===============================================
    private static int height(Node n) {
        if (n == null) return 0;

        int leftHeight  = height(n.left);
        int rightHeight = height(n.right);

        return 1 + Math.max(leftHeight, rightHeight);
     }

    //===============================================
    public static class Node{
        public int element;
        public Node parent;
        public Node left;
        public Node right; 

        //===============================================
        public Node(int value)  {
            element = value;
        }

        //===============================================
        public void copy(Node node) {
            element = node.element;
            parent  = node.parent;
            left    = node.left;
            right   = node.right;
        }
    }
}
