package recursion;

/**
 * Provides recursive and iterative implementations of summation function.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-23
 */
public class Summation {

	/** Returns the sum of 1..n for n > 0. */
	public static int sumI(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}

	/** Returns the sum of 1..n  */
	public static int sumR(int n) {
		if (n == 0) return 0;
		return sumR(n-1) + n;
	}

	/** Returns the sum of 1..n  */
	public static int sumA(int[] a, int left, int right) throws IllegalArgumentException{
		int sum = -1;
		if (a != null && a.length != 0)
		{
			sum = 0;
			if (left == right) {
				sum = a[left];
			} else {
				sum = a[left] + sumA(a, left + 1, right);
			}
		}
		return sum;
	}

	/** Drives execution. */
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			int s1 = sumI(i);
			int s2 = sumR(i);
			System.out.println(i + ": " + s1 + ", " + s2);
		}

		int sum = sumI(5);
		sum = sumR(5);
		System.out.println(sum);
	}
}
