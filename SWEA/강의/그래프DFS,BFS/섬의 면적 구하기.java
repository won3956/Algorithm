import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count;
	static int N;	//지도의 행 열 크기
	static int[][] map;	//지도 정보

	static boolean[][] visited;	//BFS 탐색 시 방문좌표 체크
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc);
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==0) continue;   
					if(visited[i][j]) continue;
					count = 0;
					bfs(i, j);
					sb.append(" "+ count);
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int sr, int sc) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		++count;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!inrange(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]==0) continue;
				que.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				++count;
			}
			
		}
	}
	public static boolean inrange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
