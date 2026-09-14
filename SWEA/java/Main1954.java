import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1954 {
	static int[][] snail;
	static int n, count;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int row, col, index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			snail = new int[n][n];
			count = 1;
			row = 0;
			col = 0;
			index = 0;
			solve();
			print(test_case);
		}

	}

	public static void solve() {
		snail[0][0] = 1;
		while (count < n * n) {
			int tr = row + dr[index];
			int tc = col + dc[index];
			if (tr >= 0 && tr < n && tc >= 0 && tc < n) {
				snail[tr][tc] = ++count;
				row = tr;
				col = tc;
			} else {
				index = (index + 1) % 4;
			}
		}
	}

	public static void print(int test_case) {
		System.out.println("*" + test_case);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}
	}
}
