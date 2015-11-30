import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Connect4 {
	static int m = 6;
	static int n = 7;
	static char[][] board = new char[m][n];

	public static void main(String[] args) {
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				board[i][j] = '-';
		Scanner sc = new Scanner(System.in);
		int player = 0;
		Random r = new Random();
		while (!isDraw()) {

			char c = player % 2 == 0 ? 'x' : 'o';
			int a = r.nextInt(6);
			int b = getVal(a);
			board[a][b] = c;
			printBoard();
			if (won(player % 2)) {
				System.out.println("Player " + (player % 2 + 1) + " wins!");
				break;
			}
			System.out.println();
			player++;
		}

	}

	private static int getVal(int a) {
		for (int i = 0; i < n; ++i)
			if (board[a][i] == '-')
				return i;
		return 0;
	}

	public static boolean won(int player) {
		if (checkHorizontal(player)) {
			System.out.println("Horizontally");
			return true;
		}
		if (checkDiagonal(player)) {
			System.out.println("diagonally");
			return true;
		}
		return false;
	}

	private static boolean checkDiagonal(int player) {
		int count = 0;
		char c = player == 0 ? 'x' : 'o';
		// leftupper diagonal
		for (int i = 3; i < m; ++i) {
			for (int j = 3; j < n; ++j) {
				count = 0;
				for (int k = 0; k < 4; ++k) {
					if (board[i - k][j - k] == c)
						count++;
				}
				if (count == 4)
					return true;
			}
		}
		// right upper diagonal
		for (int i = 3; i < m; ++i) {
			for (int j = 0; j <= n - 4; ++j) {
				count = 0;
				for (int k = 0; k < 4; ++k) {
					if (board[i - k][j + k] == c)
						count++;
				}
				if (count == 4)
					return true;
			}
		}
		return false;
	}

	private static boolean checkHorizontal(int player) {
		int count = 0;
		char c = player == 0 ? 'x' : 'o';
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j <= n - 4; j++) {
				count = 0;
				for (int k = j; k < j + 4; ++k) {
					if (board[i][k] == c)
						count++;
				}
				if (count == 4)
					return true;
			}
		}
		for (int i = 0; i <= m - 4; ++i) {
			for (int j = 0; j < n; j++) {
				count = 0;
				for (int k = i; k < i + 4; ++k) {
					if (board[k][j] == c)
						count++;
				}
				if (count == 4)
					return true;
			}
		}
		return false;
	}

	public static boolean isDraw() {
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (board[i][j] == '-')
					return false;
		return true;
	}

	public static void printBoard() {
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
