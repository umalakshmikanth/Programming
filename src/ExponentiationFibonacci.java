import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ExponentiationFibonacci {
	static ArrayList<Matrix> list = new ArrayList();

	public static void main(String[] args) {	BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");

		list.add(new Matrix(one, one, one, zero));
		for (int i = 1; i < 22; ++i) {
			Matrix matrix = getMult(list.get(i - 1));
			list.add(matrix);
		}
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
	
		for (int i = 0; i < 10; ++i) {
			Matrix m = list.get(i);
			System.out.println("i : " + i + " " + m.geta() + " " + m.getb() + " " + m.getc() + " " + m.getd());
		}
		// for (int i = 1; i < 10; ++i)
		System.out.println(getExp(a, b, n - 1));
	}

	private static BigInteger getExp(int x, int y, int n) {
		// TODO Auto-generated method stub
		BigInteger ans = new BigInteger("0");
		int i = 0;
		BigInteger e, f, g, h;
		e = f = g = h = BigInteger.ONE;
		while (n > 1) {
			if (n % 2 == 1) {
				Matrix m = list.get(i);
				System.out.println("i : " + i + " " + m.geta() + " " + m.getb() + " " + m.getc() + " " + m.getd());
				BigInteger a, b, c, d, a1, b1, c1, d1;
				a = m.geta();
				b = m.getb();
				c = m.getc();
				d = m.getd();
				
			}
			n = n / 2;
			i++;
		}

		ans = ans.add(e.multiply(BigInteger.valueOf(x)));
		ans = ans.add(f.multiply(BigInteger.valueOf(y)));
		return ans;
	}

	private static Matrix getMult(Matrix matrix) {
		// TODO Auto-generated method stub
		BigInteger a, b, c, d;
		a = b = c = d = new BigInteger("0");
		BigInteger a1 = matrix.geta();
		BigInteger b1 = matrix.getb();
		BigInteger c1 = matrix.getc();
		BigInteger d1 = matrix.getd();
		a = (a1.multiply(a1)).add(b1.multiply(c1));
		b = (a1.multiply(b1)).add(b1.multiply(d1));
		d = (c1.multiply(b1)).add(d1.multiply(d1));
		return new Matrix(a, b, b, d);
	}

	static class Matrix {
		BigInteger a, b, c, d;

		Matrix(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;

		}

		public BigInteger geta() {
			return this.a;
		}

		public BigInteger getb() {
			return this.b;
		}

		public BigInteger getc() {
			return this.c;
		}

		public BigInteger getd() {
			return this.d;
		}
	}
}
