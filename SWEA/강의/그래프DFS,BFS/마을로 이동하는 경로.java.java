import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine());
			result = 0;
			visited = new boolean[N][N];
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					char c = st.nextToken().charAt(0);
					map[i][j] = c;
				}
			}
			visited[0][0] = true;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + result);
		}
	}
	public static void dfs(int row, int col, int dist) {
		if(dist > 10) return;
		if(row == N - 1 && col == N - 1) {
			result++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(!inrange(nr, nc)) continue;
			if(map[nr][nc]=='X') continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, dist + 1);
			visited[nr][nc] = false;			
		}
	}

	public static boolean inrange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}