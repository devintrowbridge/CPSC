

public class Rod{
    static int q;
    public static void main(String[] args)  {
        int[] prices = {1, 3, 5, 8, 12, 16, 16, 17, 19, 26};
        int n = 10;
        
        memoCutRod(prices, n);
        
    }
   
    public static int memoCutRod(int[] pricesIn, int n)  {
        int[] p = pricesIn;
        int[] r = new int[n];
        for (int i = 1; i < n; i++)    {
            r[i] = -99999999;
        }
        return memoCutRodAux(p, n, r); 
    }

    public static int memoCutRodAux(int[] p, int n, int[] r)   {
        if (r[n-1] > 0)   {
            return r[n-1];
        }
        if (n == 0) {
            q = 0;
        }
        else{
            q = -999999;
            for (int i = 0; i <= n; i++)    {
                q = Math.max(q, p[i] + memoCutRodAux(p, n-i, r));
            }
        }
        r[n] = q;
        return q;
    }
}