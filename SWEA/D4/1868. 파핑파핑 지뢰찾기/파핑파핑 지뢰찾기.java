import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static char[][] arr;
	static boolean[][] visited;
	static int N, result;
	static int[] dr = {0, 1, 1, 1, 0,-1,-1,-1};
	static int[] dc = {1, 1, 0,-1,-1,-1, 0, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			visited = new boolean[N][N];
			result = 0;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j]=='.'&&!visited[i][j]&&countbomb(i, j)==0) {
						result++;
						bfs(i, j);
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j]=='.'&&!visited[i][j]) {
						result++;
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static int countbomb(int r, int c) {
		int bomb = 0;
		for(int idx =0; idx<8; idx++) {
			int nr = r + dr[idx];
			int nc = c + dc[idx];
			if(nr<0||nr>=N||nc<0||nc>=N) {
				continue;
			}
			if(arr[nr][nc]=='*') {
				bomb++;
			}
		}
		return bomb;
	}
	public static void bfs(int sr, int sc) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int row = temp[0];
			int col = temp[1];
			
			if(countbomb(row, col) == 0) {
				for(int idx =0; idx<8; idx++) {
					int nr = row + dr[idx];
					int nc = col + dc[idx];
					if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]=='*') {
						continue;
					}
					if(!visited[nr][nc]) {
						que.offer(new int[] {nr, nc});
						visited[nr][nc]=true;
					}
				}
			}
		}
	}
}
