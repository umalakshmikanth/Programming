import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int x = sc.nextInt();
		System.out.print("W");
		for (int i = 0; i < x; ++i)
			System.out.print("o");
		System.out.print("w");
	}

}
