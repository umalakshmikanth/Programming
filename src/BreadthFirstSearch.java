import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				graph[i][j] = sc.nextInt();
		int t = sc.nextInt();
		while (t-- > 0) {
			int source = sc.nextInt() - 1;
			// int dest = sc.nextInt() - 1;
			Queue queue = new Queue();
			int vertex = source;
			queue.push(vertex);
			int[] visited = new int[n];
			Arrays.fill(visited, 0);
			boolean error = true;
			int count = 1;
			do {
				vertex = queue.pop();
				if (visited[vertex] == 0) {
					// visited[vertex] = count;
					// count++;
				}
				count++;
				System.out.print((vertex + 1) + " -> ");
				for (int i = 0; i < n; ++i)
					if (visited[i] == 0 && graph[vertex][i] == 1) {
						queue.push(i);
						visited[i] = count;
					}
				// System.out.println("After : " + queue.print());

				// System.out.println("popped : " + vertex);

			} while (!queue.isEmpty());
			if (error)
				System.out.println("NO");
			for (int i = 0; i < n; ++i)
				System.out.println((i + 1) + " " + visited[i]);
		}

	}

	public static class Queue {
		ArrayList<Integer> list = new ArrayList();

		public String print() {
			return list.toString();
		}

		public void push(int x) {
			list.add(x);
		}

		public int pop() {
			return list.remove(0);
		}

		public boolean isEmpty() {
			return list.isEmpty();
		}
	}
}
