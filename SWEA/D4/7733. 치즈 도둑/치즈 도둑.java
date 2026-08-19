import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int result, N, max;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			result = 0; max = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(arr[i][j], max);
				}
			}
			
			for(int x = 0; x <= max; x++) {
				visited = new boolean[N][N];
				int count = 0;
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(arr[i][j] > x && visited[i][j]==false) {
							count++;
							bfs(i, j, x);
						}
					}
				}
				result = Math.max(result, count);
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void bfs(int i, int j, int x) {
		Queue<int[]> que = new ArrayDeque<>();
		
		que.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int idx = 0; idx < 4; idx++) {
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&visited[nr][nc]==false&&arr[nr][nc]>x) {
					que.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
