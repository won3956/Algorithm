import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 메모리:25,472KB, 시간:73ms
 * @author won3956
 *
 */
public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	static int R, C;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			arr = new int[R][C];
			visited = new boolean[R][C];
			result = 0;
			for(int i = 0; i < R; i++) {
				String str = br.readLine();
				for(int j = 0; j < C; j++) {
					char c = str.charAt(j);
					if(c=='#') arr[i][j] = 0;
					else arr[i][j] = 1;
				}
			}
			
			bfs(sr, sc);
			System.out.println("#"+tc+" "+result);
		}
	}
	public static void bfs(int sr, int sc) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		result++;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!inrange(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(arr[nr][nc]==0) continue;
				que.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				result++;
			}
		}
	}
	public static boolean inrange(int r, int c) {
		return r>=0 && r<R && c>=0 && c<R;
	}
}
