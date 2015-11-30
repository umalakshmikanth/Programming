package ProjectEuler;

public class HighTriang {
	public static void main(String args[]) {
		int noOfDivs = 0;
		long num = 0;
		int i = 1;
		while (noOfDivs < 500) {
			num = triang(i);
			noOfDivs = getDivs(num);
			System.out.println(num + " " + noOfDivs);
			i++;
		}
	}

	private static int getDivs(long num) {
		// TODO Auto-generated method stub
		int divs = 1;
		int count = 0;
		while (num % 2 == 0) {
			num /= 2;
			count++;
		}
		if (count != 0)
			divs *= (count + 1);
		for (int i = 3; i * i <= num; i += 2) {
			count = 0;
			while (num % i == 0) {
				count++;
				num /= i;
			}
			if (count != 0) {
				divs *= (count + 1);
			}
		}
		return num == 1 ? divs : divs * 2;
	}

	private static long triang(int i) {
		// TODO Auto-generated method stub
		return (i * (i + 1)) / 2;
	}
}
