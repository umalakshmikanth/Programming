package ProjectEuler;

public class PythTripl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 1000;
		for (int i = 0; i < max / 3; ++i) {
			for (int j = 0; j < max / 2; ++j) {
				int k = max - i - j;
				if (i * i + j * j == k * k)
					System.out.println(i + " " + j + " " + k + " " + (long) i * j * k);
			}
		}
	}

}
