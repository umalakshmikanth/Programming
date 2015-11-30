import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZerosFactorial {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(find(n));
		}
	}

	public static int find(int n) {
		int count = 0;

		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;

		return count;
	}
}