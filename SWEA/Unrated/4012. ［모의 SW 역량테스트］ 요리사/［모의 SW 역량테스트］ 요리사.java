import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int N, result;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			check = new boolean[N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void dfs(int cnt, int start) {

		if (cnt == N / 2) {
			int sumA = 0;
			int sumB = 0;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (check[i] && check[j]) {
						sumA += map[i][j] + map[j][i];
					}
					if (!check[i] && !check[j]) {
						sumB += map[i][j] + map[j][i];
					}
				}
			}
			result = Math.min(result, Math.abs(sumA - sumB));
			return;
		}

		for (int i = start; i < N; i++) {
			check[i] = true;
			dfs(cnt + 1, i + 1);
			check[i] = false;
		}

	}

}
