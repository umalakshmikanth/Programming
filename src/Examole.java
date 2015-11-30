import java.util.ArrayList;
import java.util.Arrays;

public class Examole {
	public static void main(String ar[]) {
		ArrayList<Integer> list1 = new ArrayList(Arrays.asList(32767, 32767, 32537, 32260, 31957));
		ArrayList<Integer> list2 = new ArrayList(
				Arrays.asList(14485, 14441, 14393, 14338, 14277, 14210, 14135, 14052, 13960));
		ArrayList<ArrayList<Integer>> myList = new ArrayList();
		myList.add(list1);
		myList.add(list2);

		for (int i = 0; i < myList.size(); ++i)
			for (int j = 0; j < myList.get(i).size(); ++j)
				System.out.println(i + " " + j + " " + myList.get(i).get(j));
	}
}
