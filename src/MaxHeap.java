import java.util.Scanner;

public class MaxHeap {
	static int max = 1007;
	static int[] heap = { 90, 89, 72, 36, 75, 70, 65, 21, 18, 15, 12, 63 };;
	static int k = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();

		int i = 0;
		while (i < p) {
			int x = sc.nextInt();
			insert(x);
			printArray();
			i++;
		}
		for (; i < n; ++i) {
			int x = sc.nextInt();
			if (x > heap[0]) {
				removeRoot();
				insert(x);
			}
			printArray();
		}
		System.out.println("Kth Largest : " + heap[0]);
	}

	public static void printArray() {
		for (int i = 0; i < k; ++i)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	public static void removeRoot() {
		// swap last with root
		heap[0] = heap[k - 1];
		k--;
		int i = 0;
		while (true) {
			// compare to left
			if (i >= k)
				return;
			int l = getLeft(i);
			if (l >= k)
				return;
			if (heap[l] > heap[i]) {
				int r = getRight(i);
				if (r >= k)
					return;
				if (heap[r] > heap[i]) {
					return;
				} else {
					swap(r, i);
					i = r;
				}
			} else if (heap[l] < heap[i]) {
				// check left to right
				l = getLeft(i);
				if (l >= k)
					return;
				int r = getRight(i);
				if (r >= k)
					return;
				if (heap[l] < heap[r]) {
					swap(i, l);
					i = l;
				} else {
					swap(i, r);
					i = r;
				}
			}
		}
	}

	public static void insert(int n) {
		if (k == 0) {
			heap[k++] = n;
			return;
		}
		heap[k++] = n;
		int prevIndex = k - 1;
		int toCheck = getRoot(k - 1);
		while (true) {
			// if it comes to root
			if (toCheck == 0) {
				if (heap[prevIndex] < heap[0]) {
					swap(prevIndex, toCheck);
				}
				return;
			} else if (heap[prevIndex] < heap[toCheck]) {
				swap(prevIndex, toCheck);
			} else {
				return;
			}
			prevIndex = toCheck;
			toCheck = getRoot(prevIndex);
		}
	}

	private static int getRoot(int i) {
		// TODO Auto-generated method stub
		return i % 2 == 0 ? (i / 2) - 1 : (i - 1) / 2;
	}

	private static int getLeft(int i) {
		// TODO Auto-generated method stub
		return 2 * i + 1;
	}

	private static int getRight(int i) {
		// TODO Auto-generated method stub
		return 2 * i + 2;
	}

	private static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

}
