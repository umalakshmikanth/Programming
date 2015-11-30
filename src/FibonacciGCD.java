
import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciGCD {
	static int mod = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt() - 1;
		long g = sc.nextLong();
		while (t-- > 0) {
			g = gcd(g, sc.nextLong());
		}
		System.out.println(g);
		System.out.println(fib(g));
	}

	private static long fib(long n) {
		// TODO Auto-generated method stub
		if (n <= 2)
			return 1;
		long c = 0;
		ArrayList<Matrix> list = new ArrayList();
		list.add(new Matrix(1, 1, 1, 0));
		for (int i = 1; i < 40; ++i) {
			Matrix matrix = getMult(list.get(i - 1));
			list.add(matrix);
			// System.out
			// .println(i + " " + matrix.geta() + " " + matrix.getb() + " " +
			// matrix.getc() + " " + matrix.getd());
		}
		int i = 0;
		Matrix ans = new Matrix(1, 0, 0, 1);
		while (n != 1) {
			if (n % 2 == 1) {
				ans = multiply(ans, list.get(i));
				/*
				 * System.out.println(i + "=" + ans.geta() + " " + ans.getb() +
				 * " " + ans.getc() + " " + ans.getd() + "=" +
				 * list.get(i).geta() + " " + list.get(i).getb() + " " +
				 * list.get(i).getc() + " " + list.get(i).getd());
				 */
			}
			n = n / 2;
			i++;
		}
		ans = multiply(ans, list.get(i));
		return ans.getb();
	}

	private static Matrix multiply(Matrix A, Matrix B) {
		// TODO Auto-generated method stub
		long a, b, c, d;
		a = b = c = d = 0;
		a = ((A.geta() * B.geta()) % mod + (A.getb() * B.getc() % mod)) % mod;
		b = ((A.geta() * B.getb()) % mod + (A.getb() * B.getd() % mod)) % mod;
		c = ((A.getc() * B.geta()) % mod + (A.getd() * B.getc() % mod)) % mod;
		d = ((A.getc() * B.getb()) % mod + (A.getd() * B.getd() % mod)) % mod;

		return new Matrix(a, b, c, d);
	}

	private static Matrix getMult(Matrix matrix) {
		// TODO Auto-generated method stub
		long a, b, c, d;
		a = b = c = d = 0;
		long a1 = matrix.geta();
		long b1 = matrix.getb();
		long c1 = matrix.getc();
		long d1 = matrix.getd();

		a = ((a1 * a1) % mod + (b1 * c1) % mod) % mod;
		b = ((a1 * b1) % mod + (b1 * d1) % mod) % mod;
		d = ((c1 * b1) % mod + (d1 * d1) % mod) % mod;
		return new Matrix(a, b, b, d);
	}

	private static long gcd(long a, long b) {
		// TODO Auto-generated method stub
		return b == 0 ? a : gcd(b, a % b);
	}

	static class Matrix {
		long a, b, c, d;

		Matrix(long a, long b, long c, long d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;

		}

		public long geta() {
			return this.a;
		}

		public long getb() {
			return this.b;
		}

		public long getc() {
			return this.c;
		}

		public long getd() {
			return this.d;
		}
	}
}
