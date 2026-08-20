import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, R, C, L;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] idxes = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };
	static int[][] fit = { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int result = 0;
			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + test_case + " " + bfs(R, C, 1));
		}
	}

	public static int bfs(int sr, int sc, int time) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!que.isEmpty() && time < L) {
			int size = que.size();
			while (size-- > 0) {
				int[] temp = que.poll();
				int row = temp[0];
				int col = temp[1];

				for (int idx : idxes[arr[row][col]]) {
					int nr = row + dr[idx];
					int nc = col + dc[idx];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == 0) {
						continue;
					}
					boolean skip = false;
					for (int i : fit[idx]) {
						if (i == arr[nr][nc]) {
							skip = true;
							break;
						}
					}
					if (!skip) {
						continue;
					}
					que.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			time++;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
}
