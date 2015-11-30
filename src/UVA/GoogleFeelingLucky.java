/* package whatever; // don't place package name! */
package UVA;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class GoogleFeelingLucky {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner scan = new Scanner(new File("C://temp//hey.txt"));
		// your code goes here
		ArrayList<String> list = new ArrayList();
		while (scan.hasNext()) {
			String s = scan.nextLine();
			list.add(s);
		}

		int[][] myArray = new int[list.size()][3];

		for (int i = 0; i < myArray.length; ++i) {
			String[] tokens = list.get(i).split(" ");
			for (int j = 0; j < tokens.length; ++j) {
				myArray[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		for (int[] a : myArray)
			System.out.println(Arrays.toString(a));
	}
}