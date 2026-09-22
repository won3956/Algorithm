import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int[][] costs;
	static int N;
	static int gr, gc;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			costs = new int[N][N];
			for (int i = 0; i < N; i++) {
			    Arrays.fill(costs[i], Integer.MAX_VALUE);
			}
			gr = gc = N - 1;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			bfs(new int[] {0, 0, 0});
			
			System.out.println("#"+test_case+" "+costs[gr][gc]);
		}
	}
	public static void bfs(int[] start) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(start);
		costs[start[0]][start[1]] = 0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1]+ dc[i];
				if(!isRange(nr, nc)) continue;
				int cost = cur[2] + map[nr][nc];
				if(costs[nr][nc]<=cost) {
					continue;
				}else {
					costs[nr][nc] = cost;
				}
				
				costs[nr][nc] = cost;
				que.offer(new int[] {nr, nc, cost});
			}
		}
	}
	public static boolean isRange(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
